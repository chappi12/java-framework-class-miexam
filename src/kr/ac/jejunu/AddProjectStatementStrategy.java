package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by SeungChan on 2017-04-21.
 */
public class AddProjectStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Object object, Connection connection) throws SQLException {
        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("insert into productinfo (id, title, price) VALUES (?,?,?)");
        Product product = (Product) object;
        preparedStatement.setLong(1, product.getId());
        preparedStatement.setString(2, product.getTitle());
        preparedStatement.setInt(3, product.getPrice());
        return preparedStatement;
    }
}
