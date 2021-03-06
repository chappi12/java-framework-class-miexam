package kr.ac.jejunu;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import java.sql.SQLException;
import java.util.Random;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNull;

public class ProductDaoTest {
    private ProductDao productDao;

    @Before
    public void setup(){
        ApplicationContext context = new GenericXmlApplicationContext("daoFactory.xml");
        productDao = context.getBean("productDao", ProductDao.class);
    }

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        Long id = 1L;
        String title = "제주감귤";
        Integer price = 15000;

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

        productDao.add(product);
        Product check = productDao.get(id);

        assertThat(id, is(check.getId()));
        assertThat(title, is(check.getTitle()));
        assertThat(price, is(check.getPrice()));
    }

    @Test
    public void update() throws SQLException, ClassCastException, ClassNotFoundException {
        Long id = Long.valueOf(new Random().nextInt(5000));
        String title = "오렌지";
        Integer price = 20000;

        Product product = new Product();
        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);

        productDao.add(product);

        String retitle = "retitle";
        Integer reprice = 8000;

        product.setTitle(retitle);
        product.setPrice(reprice);

        productDao.update(product);

        Product check = productDao.get(id);

        assertThat(retitle, is(check.getTitle()));
        assertThat(reprice,is(check.getPrice()));

    }
    @Test
    public void delete() throws SQLException, ClassNotFoundException {
        Product product = new Product();

        Long id = Long.valueOf(new Random().nextInt(5000));
        String title = "오렌지";
        Integer price = 20000;

        product.setId(id);
        product.setTitle(title);
        product.setPrice(price);
        productDao.add(product);

        productDao.delete(id);
        assertNull(productDao.get(id));
    }
}
