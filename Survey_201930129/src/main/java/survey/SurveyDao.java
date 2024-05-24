package survey;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

public class SurveyDao {

    private JdbcTemplate jdbcTemplate;

    public SurveyDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
/*
    public void insert(Survey survey) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                // 두 번째 파라미터는 자동 생성되는 키 컬럼 목록을 지정할 때 사용
                PreparedStatement preparedStatement = con.prepareStatement(
                        "insert into SURVEY(Q1, Q2, Q3, RespondentName, RespondentAge, REGDATE) values (?,?,?,?,?,?)"
                        , new String[]{"ID"});
                preparedStatement.setString(1, survey.getEmail());
                preparedStatement.setString(2, survey.getPassword());
                preparedStatement.setString(3, survey.getName());
                preparedStatement.setTimestamp(4, Timestamp.valueOf(survey.getRegisterDateTime()));
                return preparedStatement;
            }
        }, keyHolder);
        Number keyValue = keyHolder.getKey();
        member.setId(keyValue.longValue());
    }*/
}
