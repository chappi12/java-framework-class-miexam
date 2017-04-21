package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class ProductDao {
    private jdbcContext jdbcContext;

    public ProductDao() {

    }


    public Product get(Long id) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new GetProjectStatementStrategy(id);

        return jdbcContext.jdbcContextWithStatementStrategyForQuery(statementStrategy);
    }



    public void add(Product product) throws ClassNotFoundException, SQLException {
        StatementStrategy statementStrategy = new AddProjectStatementStrategy(product);

        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }



    public void delete(Long id) throws SQLException {
        StatementStrategy statementStrategy = new DeleteProjectStatementStrategy(id);


        jdbcContext.jdbcContextWithStatementStrategyForUpdate(statementStrategy);
    }




    public void setJdbcContext(kr.ac.jejunu.jdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }


    //"delete from userinfo where id = ?"
}
