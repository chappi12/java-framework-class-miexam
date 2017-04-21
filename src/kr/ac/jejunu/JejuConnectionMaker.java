package kr.ac.jejunu;

import org.springframework.jdbc.datasource.SimpleDriverDataSource;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by SeungChan on 2017-04-21.
 */
public class JejuConnectionMaker extends SimpleDriverDataSource {
    public JejuConnectionMaker() {
        this.setDriverClass(Driver.class);
        this.setUrl("jdbc:mysql://117.17.102.106/chappi?characterEncoding=utf-8");
        this.setUsername("root");
        this.setPassword("1234");
    }
}
