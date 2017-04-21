package kr.ac.jejunu;

import javax.sql.DataSource;
import java.sql.*;

public class ProductDao {
    private jdbcContext jdbcContext;

    public ProductDao() {

    }


    public Product get(final Long id) throws ClassNotFoundException, SQLException {
        return jdbcContext.jdbcContextWithStatementStrategyForQuery(new StatementStrategy() {
            @Override
            public PreparedStatement makeStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement;
                preparedStatement = connection.prepareStatement("select * from productinfo where id = ?");
                preparedStatement.setLong(1, id);
                return preparedStatement;
            }
        });
    }



    public void add(final Product product) throws ClassNotFoundException, SQLException {

        jdbcContext.jdbcContextWithStatementStrategyForUpdate(new StatementStrategy() {
            @Override
            public PreparedStatement makeStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement;
                preparedStatement = connection.prepareStatement("insert into productinfo (id, title, price) VALUES (?,?,?)");
                preparedStatement.setLong(1, product.getId());
                preparedStatement.setString(2, product.getTitle());
                preparedStatement.setInt(3, product.getPrice());
                return preparedStatement;            }
        });
    }



    public void delete(final Long id) throws SQLException {

        jdbcContext.jdbcContextWithStatementStrategyForUpdate(new StatementStrategy() {
            @Override
            public PreparedStatement makeStatement(Connection connection) throws SQLException {
                PreparedStatement preparedStatement;
                preparedStatement = connection.prepareStatement("delete from productinfo where id = ?");
                preparedStatement.setLong(1, (Long) id);
                return preparedStatement;
            }
        });
    }




    public void setJdbcContext(kr.ac.jejunu.jdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }


    //"delete from userinfo where id = ?"
}
