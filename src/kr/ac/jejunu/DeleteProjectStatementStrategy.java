package kr.ac.jejunu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by SeungChan on 2017-04-21.
 */
public class DeleteProjectStatementStrategy implements StatementStrategy {
    @Override
    public PreparedStatement makeStatement(Object object, Connection connection) throws SQLException {

        PreparedStatement preparedStatement;
        preparedStatement = connection.prepareStatement("delete from productinfo where id = ?");
        preparedStatement.setLong(1, (Long) object);
        return preparedStatement;
    }
}
