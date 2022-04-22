package kr.ac.jejunu.userdao;

public class DaoFactory {
    public UserDao GetUserDao() {
        return new UserDao(getConnectionMaker());
    }

    private JejuConnectionMaker getConnectionMaker() {
        return new JejuConnectionMaker();
    }
}
