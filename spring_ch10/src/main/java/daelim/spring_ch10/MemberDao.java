package daelim.spring_ch10;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class MemberDao {

  private JdbcTemplate jdbcTemplate;

  public MemberDao(DataSource dataSource) {
    this.jdbcTemplate = new JdbcTemplate(dataSource);
  }

  public class MemberRowMapper implements RowMapper<Member> {
    @Override
    public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
      Member member = new Member(rs.getString("EMAIL"), rs.getString("PASSWORD"),
              rs.getString("NAME"), rs.getTimestamp("REGDATE").toLocalDateTime());
      member.setId(rs.getLong("ID"));
      return member;
    }
  }

  public Member selectByEmail(String email) {
    List<Member> members = jdbcTemplate.query(
            "SELECT * FROM MEMBER WHERE EMAIL = ?",
            new MemberRowMapper(), email);
    return members.isEmpty() ? null : members.get(0);
  }

  public void insert(Member member) {
    KeyHolder keyHolder = new GeneratedKeyHolder();
    jdbcTemplate.update(new PreparedStatementCreator() {
      @Override
      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
        // 두 번째 파라미터는 자동 생성되는 키 컬럼 목록을 지정할 때 사용
        PreparedStatement preparedStatement = con.prepareStatement(
                "insert into MEMBER(EMAIL, PASSWORD, NAME, REGDATE) values (?,?,?,?)"
                , new String[]{"ID"});
        preparedStatement.setString(1, member.getEmail());
        preparedStatement.setString(2, member.getPassword());
        preparedStatement.setString(3, member.getName());
        preparedStatement.setTimestamp(4, Timestamp.valueOf(member.getRegisterDateTime()));
        return preparedStatement;
      }
    }, keyHolder);
    Number keyValue = keyHolder.getKey();
    member.setId(keyValue.longValue());
  }

  public void update(Member member) {
    jdbcTemplate.update("update MEMBER set NAME =?, PASSWORD = ? where EMAIL = ?",
            member.getName(), member.getPassword(), member.getEmail());
  }

  public void delete(Member member) {
//        map.remove(member.getEmail(), member);
  }

//    public Collection<Member> selectAll() {
//        return map.values();
//    }

  public List<Member> selectAll() {
    List<Member> results = jdbcTemplate.query(
            "select * from MEMBER",
            new MemberRowMapper()
    );
    return results;
  }

  public int count() {
    Integer count = jdbcTemplate.queryForObject("select count(*) from MEMBER", Integer.class);
    return count;
  }
}


