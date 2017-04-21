package kr.ac.jejunu;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.*;

public class ProductDao {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Product get(Long id) throws ClassNotFoundException, SQLException {
        String query = "select * from product where id = ?";
        Object[] params = new Object[]{id};
        Product product = null;
        try {
            product = jdbcTemplate.queryForObject(query, params, (resultSet, i) -> {
                Product product1 = new Product();
                product1.setId(resultSet.getLong("id"));
                product1.setTitle(resultSet.getString("title"));
                product1.setPrice(resultSet.getInt("price"));
                return product1;
            });
        } catch (DataAccessException e) {
            throw e;
        }
        return product;
    }



    public void add(final Product product) throws ClassNotFoundException, SQLException {
        String query = "insert into productinfo (id, title, price) VALUES (?,?,?)";
        Object[] params = new Object[] {product.getId(), product.getTitle(), product.getPrice()};

        jdbcTemplate.update(query, params);
    }



    public void delete(final Long id) throws SQLException {
        String query = "delete from productinfo where id = ?";
        Object[] params = new Object[] {id};

        jdbcTemplate.update(query, params);
    }

    public void update(Product product) throws SQLException {
        String sql = "update product set title = ?, price = ? where id = ?";
        Object[] params = new Object[]{product.getTitle(),product.getPrice(),product.getId()};
        jdbcTemplate.update(sql, params);
    }



    //"delete from userinfo where id = ?"
}
