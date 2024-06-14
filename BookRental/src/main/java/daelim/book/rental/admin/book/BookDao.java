package daelim.book.rental.admin.book;

import daelim.book.rental.admin.member.AdminMemberVo;
import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookDao {
    
    JdbcTemplate jdbcTemplate;
    
    @Autowired
    public BookDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public boolean isISBN(String isbn) {
        System.out.println("[BookDao] isISBN() : " + isbn);
        String sql = "SELECT count(*) FROM TB_BOOK WHERE ISBN = ?";
        int result = jdbcTemplate.queryForObject(sql, Integer.class, isbn);
        
        return result > 0 ? true : false;
    }
    
    public int insertBook(BookVo bookVo) {
        System.out.println("[BookDao] insertBook()");
        String sql = "INSERT INTO TB_BOOK (thumbnail, name, author, publisher, publishYear, isbn, callNumber, rentalAble, regDate, modDate) VALUES (?,?,?,?,?,?,?,?, NOW(), NOW())";
        int result = -1;
        try {
            result = jdbcTemplate.update(sql,
                    bookVo.getThumbnail(),
                    bookVo.getName(),
                    bookVo.getAuthor(),
                    bookVo.getPublisher(),
                    bookVo.getPublishYear(),
                    bookVo.getIsbn(),
                    bookVo.getCallNumber(),
                    bookVo.getRentalAble());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public List<BookVo> selectBook(String name) {
        System.out.println("[BookDao] selectBook(String)");
        String sql = "SELECT * FROM TB_BOOK WHERE name = ?";
        List<BookVo> bookVos = new ArrayList<>();
        try {
            bookVos = jdbcTemplate.query(sql, new RowMapper<BookVo>() {
                @Override
                public BookVo mapRow(ResultSet rs, int rowNum) throws SQLException {
                    BookVo bookVo = new BookVo();
                    bookVo.setNo(rs.getInt("no"));
                    bookVo.setThumbnail(rs.getString("thumbnail"));
                    bookVo.setName(rs.getString("name"));
                    bookVo.setAuthor(rs.getString("author"));
                    bookVo.setPublisher(rs.getString("publisher"));
                    bookVo.setPublishYear(rs.getString("publishYear"));
                    bookVo.setIsbn(rs.getString("isbn"));
                    bookVo.setCallNumber(rs.getString("callNumber"));
                    bookVo.setRentalAble(rs.getInt("rentalAble"));
                    bookVo.setRegDate(rs.getString("regDate"));
                    bookVo.setModDate(rs.getString("modDate"));
                    return bookVo;
                }
            }, name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookVos;
    }
    
    public List<BookVo> selectAllBook() {
        System.out.println("[BookDao] selectAllBook()");
        String sql = "SELECT * FROM TB_BOOK";
        List<BookVo> bookVoList = new ArrayList<>();
        try {
            bookVoList = jdbcTemplate.query(sql, new RowMapper<BookVo>() {
                @Override
                public BookVo mapRow(ResultSet rs, int rowNum) throws SQLException {
                    BookVo bookVo = new BookVo();
                    bookVo.setNo(rs.getInt("no"));
                    bookVo.setThumbnail(rs.getString("thumbnail"));
                    bookVo.setName(rs.getString("name"));
                    bookVo.setAuthor(rs.getString("author"));
                    bookVo.setPublisher(rs.getString("publisher"));
                    bookVo.setPublishYear(rs.getString("publishYear"));
                    bookVo.setIsbn(rs.getString("isbn"));
                    bookVo.setCallNumber(rs.getString("callNumber"));
                    bookVo.setRentalAble(rs.getInt("rentalAble"));
                    bookVo.setRegDate(rs.getString("regDate"));
                    bookVo.setModDate(rs.getString("modDate"));
                    return bookVo;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookVoList;
    }
    
    public BookVo selectById(int no) {
        System.out.println("[BookDao] selectById()");
        String sql = "SELECT * FROM TB_BOOK WHERE no = ?";
        List<BookVo> BookVos = new ArrayList<>();
        try {
            BookVos = jdbcTemplate.query(sql, new RowMapper<BookVo>() {
                @Override
                public BookVo mapRow(ResultSet rs, int rowNum) throws SQLException {
                    BookVo bookVo = new BookVo();
                    bookVo.setNo(rs.getInt("no"));
                    bookVo.setThumbnail(rs.getString("thumbnail"));
                    bookVo.setName(rs.getString("name"));
                    bookVo.setAuthor(rs.getString("author"));
                    bookVo.setPublisher(rs.getString("publisher"));
                    bookVo.setPublishYear(rs.getString("publishYear"));
                    bookVo.setIsbn(rs.getString("isbn"));
                    bookVo.setCallNumber(rs.getString("callNumber"));
                    bookVo.setRentalAble(rs.getInt("rentalAble"));
                    bookVo.setRegDate(rs.getString("regDate"));
                    bookVo.setModDate(rs.getString("modDate"));
                    return bookVo;
                }
            }, no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return BookVos.size() > 0 ? BookVos.get(0) : null;
    }
    
    public int updateBook(BookVo bookVo) {
        System.out.println("[BookDao] updateBook()");
        System.out.println(bookVo.getNo() + " : " + bookVo.getThumbnail());
        int result = -1;
        try {
            result = jdbcTemplate.update("update TB_BOOK set thumbnail=?, name=?, author=?, publisher=?, publishYear=?, isbn=?, callNumber=?, rentalAble=?, modDate = NOW() where no = ?",
                    bookVo.getThumbnail(), bookVo.getName(), bookVo.getAuthor(), bookVo.getPublisher(), bookVo.getPublishYear(), bookVo.getIsbn(), bookVo.getCallNumber(), bookVo.getRentalAble(), bookVo.getNo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    
    public int deleteBook(int no) {
        System.out.println("[BookDao] deleteBook()");
        int result = -1;
        try {
            result = jdbcTemplate.update("DELETE FROM TB_BOOK WHERE no = " + no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
