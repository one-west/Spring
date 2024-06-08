package daelim.book.rental.admin.book;

import daelim.book.rental.BookVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
