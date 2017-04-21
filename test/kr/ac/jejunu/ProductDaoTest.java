package kr.ac.jejunu;

import org.junit.Test;

import java.sql.SQLException;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ProductDaoTest {
    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

        ProductDao productDao = new ProductDao();
        Product product = productDao.get(id);
        assertThat(id, is(product.getId()));
        assertThat(title, is(product.getTitle()));
        assertThat(price, is(product.getPrice()));
    }

    @Test
    public void add() throws SQLException, ClassNotFoundException {
        Product product = new Product();

        Long id = Long.valueOf(new Random().nextInt(5000));
        String title = "오렌지";
        Integer price = 20000;

        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);

        ProductDao productDao = new ProductDao();
        productDao.add(product);
        Product check = productDao.get(id);

        assertThat(id, is(check.getId()));
        assertThat(title, is(check.getTitle()));
        assertThat(price, is(check.getPrice()));
    }
}
