package org.ccd.jdbc.repository;

import org.ccd.jdbc.domain.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class TestJDBCRepository {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public TestJDBCRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void saveAll(List<Test> testList) {
        String sql = "INSERT INTO " +
                "test (value1, value2, value3, value4, value5) " +
                "VALUES (?, ?, ?, ?, ?)";
        jdbcTemplate.batchUpdate(sql, testList, testList.size(),
                (ps, test) ->  {
                    ps.setString(1, test.getValue1());
                    ps.setString(2, test.getValue2());
                    ps.setString(3, test.getValue3());
                    ps.setString(4, test.getValue4());
                    ps.setString(5, test.getValue5());
                });
    }
}
