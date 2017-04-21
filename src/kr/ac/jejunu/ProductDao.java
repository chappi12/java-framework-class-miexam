package kr.ac.jejunu;

import java.sql.*;

public class ProductDao {
    public Product get(Long id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://117.17.102.106/chappi", "root", "1234");
        PreparedStatement preparedStatement = connection.prepareStatement("select * from productinfo where id = ?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();
        Product product = new Product();
        product.setId(resultSet.getLong("id"));
        product.setTitle(resultSet.getString("title"));
        product.setPrice(resultSet.getInt("price"));
        resultSet.close();
        preparedStatement.close();
        connection.close();
        return product;
    }

    public void add(Product product) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://117.17.102.106/chappi", "root", "1234");
        PreparedStatement preparedStatement = connection.prepareStatement("insert into productinfo (id, title, price) VALUES (?,?,?)");
        preparedStatement.setLong(1, product.getId());
        preparedStatement.setString(2, product.getTitle());
        preparedStatement.setInt(3, product.getPrice());
        preparedStatement.executeUpdate();

        preparedStatement.close();
        connection.close();
    }

    //"delete from userinfo where id = ?"
}
