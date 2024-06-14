package daelim.book.rental.user.book;

import daelim.book.rental.admin.book.BookService;
import daelim.book.rental.admin.book.BookVo;
import daelim.book.rental.admin.util.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/book/user")
public class BookUserController {
    
    @Autowired
    private BookService bookService;
    
    @Autowired
    private UploadFileService uploadFileService;
    
    @GetMapping("/registerBookForm")
    public String registerBookForm() {
        System.out.println("[BookController] registerBookForm()");
        String nextPage = "admin/book/register_book_form";
        return nextPage;
    }
    
    @PostMapping("/registerBookConfirm")
    public String registerBookConfirm(BookVo bookVo, MultipartFile file) {
        System.out.println("[BookController] registerBookConfirm()");
        String nextPage = "admin/book/register_book_ok";
        
        String saveFileName = uploadFileService.upload(file);
        if (saveFileName != null) {
            bookVo.setThumbnail(saveFileName);
            int result = bookService.register(bookVo);
            if (result <= 0) nextPage = "admin/book/register_book_ng";
        } else {
            nextPage = "admin/book/register_book_ng";
        }
        
        return nextPage;
    }
    
    @GetMapping("/searchBookConfirm")
    public String searchBookConfirm(Model model) {
        System.out.println("[BookController] searchBookConfirm()");
        String nextPage = "admin/book/search_book";
        List<BookVo> bookVos = bookService.selectAllBook();
        model.addAttribute("bookVos", bookVos);
        return nextPage;
    }
    
    @GetMapping("/bookDetail")
    public String bookDetail(@RequestParam("no") int no, Model model) {
        System.out.println("[BookController] bookDetail()");
        
        BookVo bookVo = bookService.selectById(no);
        model.addAttribute("bookVo", bookVo);
        String nextPage = "admin/book/book_detail";
        return nextPage;
    }
    
    @GetMapping("/modifyBookForm")
    public String modifyBookForm(@RequestParam("no") int no, Model model, HttpSession session) {
        System.out.println("[BookController] modifyBookForm()");
        
        if (session.getAttribute("loginedAdminMemberVo") == null) {
            return "redirect:/admin/member/loginForm";
        }
        
        BookVo bookVo = bookService.selectById(no);
        model.addAttribute("bookVo", bookVo);
        
        String nextPage = "admin/book/modify_book_form";
        return nextPage;
    }
    
    @PostMapping("/modifyBookConfirm")
    public String modifyBookConfirm(BookVo bookVo, MultipartFile file) {
        System.out.println("[BookController] modifyBookConfirm()");
        String nextPage = "admin/book/book_detail";
        
        String saveFileName = uploadFileService.upload(file);
        if (saveFileName != null) {
            bookVo.setThumbnail(saveFileName);
            int result = bookService.updateBook(bookVo);
            if (result <= 0) {
                nextPage = "admin/book/modify_book_form";
            }
        } else {
            nextPage = "admin/book/modify_book_form";
        }
        return nextPage;
    }
    
    @GetMapping("/deleteBookForm")
    public String deleteBookForm(@RequestParam("no") int no) {
        System.out.println("[BookController] modifyBookForm()");
        
        bookService.deleteBook(no);
        String nextPage = "admin/book/book_detail";
        return nextPage;
    }
    
    @GetMapping("/getAllBooks")
    public String getAllBooks(Model model) {
        System.out.println("[BookController] getAllBooks()");
        String nextPage = "admin/book/full_list_of_books";
        
        List<BookVo> bookVos = bookService.selectAllBook();
        model.addAttribute("bookVos", bookVos);
        
        return nextPage;
    }
    
    @GetMapping("/enterBookshelf")
    public String enterBookshelf(Model model) {
        System.out.println("[BookController] enterBookshelf()");
        String nextPage = "user/book/enterBookshelf";
        
        return nextPage;
    }
}