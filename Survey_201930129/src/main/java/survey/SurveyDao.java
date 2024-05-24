package survey;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class SurveyDao {
    
    private JdbcTemplate jdbcTemplate;
    
    public SurveyDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    public void insert(Survey survey) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement preparedStatement = con.prepareStatement(
                        "insert into SURVEY(Q1, Q2, Q3, RespondentName, RespondentAge, REGDATE) values (?,?,?,?,?,?)"
                        , new String[]{"ID"});
                preparedStatement.setString(1, survey.getQ1());
                preparedStatement.setString(2, survey.getQ2());
                preparedStatement.setString(3, survey.getQ3());
                preparedStatement.setString(4, survey.getRespondentName());
                preparedStatement.setInt(5, survey.getRespondentAge());
                preparedStatement.setTimestamp(6, Timestamp.valueOf(survey.getRegDate()));
                return preparedStatement;
            }
        }, keyHolder);
        Number keyValue = keyHolder.getKey();
        survey.setId(keyValue.longValue());
    }
    
    public List<Survey> selectAll() {
        System.out.println("[SurveyDao.selectAll()]");
        String sql = "SELECT * FROM SURVEY";
        List<Survey> surveyList = new ArrayList<>();
        try {
            surveyList = jdbcTemplate.query(sql, new RowMapper<Survey>() {
                @Override
                public Survey mapRow(ResultSet rs, int rowNum) throws SQLException {
                    Survey survey = new Survey();
                    survey.setId(rs.getLong("ID"));
                    survey.setQ1(rs.getString("Q1"));
                    survey.setQ2(rs.getString("Q2"));
                    survey.setQ3(rs.getString("Q3"));
                    survey.setRespondentName(rs.getString("RespondentName"));
                    survey.setRespondentAge(rs.getInt("RespondentAge"));
                    survey.setRegDate(rs.getTimestamp("REGDATE").toLocalDateTime());
                    return survey;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return surveyList;
    }
}
