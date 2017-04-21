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
        final String query = "insert into productinfo (id, title, price) VALUES (?,?,?)";
        final Object[] params = new Object[] {product.getId(), product.getTitle(), product.getPrice()};

        jdbcContext.update(query, params);
    }



    public void delete(final Long id) throws SQLException {
        final String query = "delete from productinfo where id = ?";
        final Object[] params = new Object[] {id};

        jdbcContext.update(query, params);
    }


    public void setJdbcContext(kr.ac.jejunu.jdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }


    //"delete from userinfo where id = ?"
}
