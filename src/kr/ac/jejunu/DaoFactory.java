package kr.ac.jejunu;

/**
 * Created by SeungChan on 2017-04-21.
 */
public class DaoFactory {
    public ProductDao getUserDao() {
        return new ProductDao(getConnectionMaker());
    }

    private JejuConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
