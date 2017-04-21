package kr.ac.jejunu;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by SeungChan on 2017-04-21.
 */
@Configuration
public class DaoFactory {
    @Bean
    public ProductDao getProductDao() {
        return new ProductDao(getConnectionMaker());
    }

    @Bean
    private JejuConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
