package daelim.book.rental.user.member;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserMemberDao {
    
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    @Autowired
    public UserMemberDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public int insertUserAccount(UserMemberVo userMemberVo) {
        System.out.println("[UserMemberDao] insertAdminAccount()");
        List<String> args = new ArrayList<>();
        String sql = "INSERT INTO TB_USER_MEMBER (";
        System.out.println(userMemberVo.getId());
        
        sql += "id, ";
        args.add(userMemberVo.getId());
        
        sql += "pw, ";
        args.add(bCryptPasswordEncoder.encode(userMemberVo.getPw()));
        
        sql += "name, ";
        args.add(userMemberVo.getName());
        
        sql += "gender, ";
        args.add(userMemberVo.getGender());
        
        sql += "email, ";
        args.add(userMemberVo.getEmail());
        
        sql += "phone, ";
        args.add(userMemberVo.getPhone());
        
        sql += "regDate, modDate) ";
        
        sql += "VALUES (?,?,?,?,?,?,NOW(), NOW())";
        
        int result = -1;
        try {
            result = jdbcTemplate.update(sql, args.toArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return result;
        
    }
    
    public boolean exsitUserAccount(String id) {
        System.out.println("[UserMemberDao] exsitUserAccount()");
        String sql = "SELECT COUNT(*) FROM TB_USER_MEMBER WHERE id = ?";
        int result = jdbcTemplate.queryForObject(sql, Integer.class, id);
        
        if (result > 0) return true;
        else return false;
    }
    
    public UserMemberVo selectUser(UserMemberVo userMemberVo) {
        System.out.println("[UserMemberDao] selectUser()");
        String sql = "SELECT * FROM TB_USER_MEMBER WHERE id =?";
        List<UserMemberVo> userMemberVoList = new ArrayList<>();
        try {
            userMemberVoList = jdbcTemplate.query(sql, new RowMapper<UserMemberVo>() {
                @Override
                public UserMemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
                    UserMemberVo userMemberVo = new UserMemberVo();
                    userMemberVo.setNo(rs.getInt("no"));
                    userMemberVo.setId(rs.getString("id"));
                    userMemberVo.setPw(rs.getString("pw"));
                    userMemberVo.setName(rs.getString("name"));
                    userMemberVo.setGender(rs.getString("gender"));
                    userMemberVo.setEmail(rs.getString("email"));
                    userMemberVo.setPhone(rs.getString("phone"));
                    userMemberVo.setRegDate(rs.getString("regDate"));
                    userMemberVo.setModDate(rs.getString("modDate"));
                    return userMemberVo;
                }
            }, userMemberVo.getId());
            
            if (!bCryptPasswordEncoder.matches(userMemberVo.getPw(), userMemberVoList.get(0).getPw())) {
                userMemberVoList.clear();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return userMemberVoList.size() > 0 ? userMemberVoList.get(0) : null;
    }
    
    public UserMemberVo selectUser(int no) {
        System.out.println("[UserMemberDao] selectUser(int)");
        String sql = "SELECT * FROM TB_USER_MEMBER WHERE no = ?";
        List<UserMemberVo> userMemberVos = new ArrayList<>();
        try {
            userMemberVos = jdbcTemplate.query(sql, new RowMapper<UserMemberVo>() {
                @Override
                public UserMemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
                    UserMemberVo userMemberVo = new UserMemberVo();
                    userMemberVo.setNo(rs.getInt("no"));
                    userMemberVo.setId(rs.getString("id"));
                    userMemberVo.setName(rs.getString("name"));
                    userMemberVo.setPw(rs.getString("pw"));
                    userMemberVo.setGender(rs.getString("gender"));
                    userMemberVo.setEmail(rs.getString("email"));
                    userMemberVo.setPhone(rs.getString("phone"));
                    userMemberVo.setRegDate(rs.getString("regDate"));
                    userMemberVo.setModDate(rs.getString("modDate"));
                    return userMemberVo;
                }
            }, no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userMemberVos.size() > 0 ? userMemberVos.get(0) : null;
    }
    
    public UserMemberVo selectUser(String id, String name, String email) {
        System.out.println("[UserMemberDao] selectUser(String id, String name, String email)");
        String sql = "SELECT * FROM TB_USER_MEMBER WHERE id = ? AND name = ? AND email = ?";
        
        List<UserMemberVo> userMemberVoList = new ArrayList<>();
        try {
            userMemberVoList = jdbcTemplate.query(sql, new RowMapper<UserMemberVo>() {
                @Override
                public UserMemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
                    UserMemberVo userMemberVo = new UserMemberVo();
                    userMemberVo.setNo(rs.getInt("no"));
                    userMemberVo.setId(rs.getString("id"));
                    userMemberVo.setName(rs.getString("name"));
                    userMemberVo.setPw(rs.getString("pw"));
                    userMemberVo.setGender(rs.getString("gender"));
                    userMemberVo.setEmail(rs.getString("email"));
                    userMemberVo.setPhone(rs.getString("phone"));
                    userMemberVo.setRegDate(rs.getString("regDate"));
                    userMemberVo.setModDate(rs.getString("modDate"));
                    return userMemberVo;
                }
            }, id, name, email);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userMemberVoList.size() > 0 ? userMemberVoList.get(0) : null;
    }
    
    public List<UserMemberVo> selectAllUser() {
        System.out.println("[UserMemberDao] selectAllUser()");
        String sql = "SELECT * FROM TB_USER_MEMBER";
        List<UserMemberVo> adminMemberVoList = new ArrayList<>();
        try {
            adminMemberVoList = jdbcTemplate.query(sql, new RowMapper<UserMemberVo>() {
                @Override
                public UserMemberVo mapRow(ResultSet rs, int rowNum) throws SQLException {
                    UserMemberVo userMemberVo = new UserMemberVo();
                    userMemberVo.setNo(rs.getInt("no"));
                    userMemberVo.setId(rs.getString("id"));
                    userMemberVo.setName(rs.getString("name"));
                    userMemberVo.setPw(rs.getString("pw"));
                    userMemberVo.setGender(rs.getString("gender"));
                    userMemberVo.setEmail(rs.getString("email"));
                    userMemberVo.setPhone(rs.getString("phone"));
                    userMemberVo.setRegDate(rs.getString("regDate"));
                    userMemberVo.setModDate(rs.getString("modDate"));
                    return userMemberVo;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return adminMemberVoList;
    }
    
    /**
     * @param no
     * @return 승인여부 처리
     */
    public int updateAdminAccount(int no) {
        System.out.println("[AdminMemberDao] updateAdminAccount()");
        String sql = "UPDATE TB_USER_MEMBER SET approval = 1 WHERE no = ?";
        int result = -1;
        try {
            result = jdbcTemplate.update(sql, no);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * @param adminMemberVo
     * @return 계정 수정 처리
     */
    public int updateAdminAccount(UserMemberVo adminMemberVo) {
        System.out.println("[AdminMemberDao] updateAdminAccount(AdminMemberVo)");
        String sql = "UPDATE TB_USER_MEMBER SET name=?, gender=?, email=?, phone=?, modDate=now() WHERE no=?";
        int result = -1;
        try {
            result = jdbcTemplate.update(sql, adminMemberVo.getName(), adminMemberVo.getGender(), adminMemberVo.getEmail(), adminMemberVo.getPhone(), adminMemberVo.getNo());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    
    public int updatePassword(String id, String newPassword) {
        System.out.println("[AdminMemberDao] updatePassword(String id, String newPassword)");
        String sql = "UPDATE TB_USER_MEMBER SET password = ?, modDate = now() WHERE id = ?";
        int result = -1;
        try {
            result = jdbcTemplate.update(sql, bCryptPasswordEncoder.encode(newPassword), id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}