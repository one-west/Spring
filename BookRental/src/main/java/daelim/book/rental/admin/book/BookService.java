package daelim.book.rental.admin.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    
    final static public int Book_ISBN_ALREDDY_EXIST = 0; // 이미 등록된 도서
    final static public int Book_ISBN_CREATE_SUCCESS = 1; // 신규 도서 등록 성공
    final static public int Book_ISBN_CREATE_FAIL = -1; // 신규 도서 등록 실패
    
    @Autowired
    private BookDao bookDao;
    
    public int register(BookVo bookVo) {
        System.out.println("[BookService] register()");
        
        boolean isISBN = bookDao.isISBN(bookVo.getIsbn());
        
        if (!isISBN) {
            int result = bookDao.insertBook(bookVo);
            if (result > 0) return Book_ISBN_CREATE_SUCCESS;
            else return Book_ISBN_CREATE_FAIL;
        } else {
            return Book_ISBN_ALREDDY_EXIST;
        }
    }
    
    public List<BookVo> selectBook(String name) {
        System.out.println("[BookService] selectBook()");
        return bookDao.selectBook(name);
    }
    
    public List<BookVo> selectAllBook() {
        System.out.println("[BookService] selectAllBook()");
        return bookDao.selectAllBook();
    }
    
    public BookVo selectById(int no) {
        System.out.println("[BookService] selectById()");
        return bookDao.selectById(no);
    }
    
    public int updateBook(BookVo bookVo) {
        System.out.println("[BookService] updateBook()");
        return bookDao.updateBook(bookVo);
    }
    
    public int deleteBook(int no) {
        System.out.println("[BookService] deleteBook()");
        return bookDao.deleteBook(no);
    }
}
