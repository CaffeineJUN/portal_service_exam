package kr.ac.jejunu.userdao;

import java.sql.*;

public class UserDao {
    private final JdbcContext jdbcContext;

    public UserDao(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext;
    }

    public User get(Integer id) throws SQLException {
        Object[] params = new Object[] {id};
        String sql = "select * from userinfo where id = ?";
        return jdbcContext.jdbcContextForGet(params, sql);
    }

    public void insert(User user) throws SQLException {
        Object[] params = new Object[] {user.getName(),user.getPassword()};
        String sql = "insert into userinfo (name,password) values (?,?)";
        jdbcContext.jdbcContextForInsert(user, params, sql, this);
    }

    public void update(User user) throws SQLException {
        Object[] params = new Object[] {user.getName(),user.getPassword(),user.getId()};
        String sql = "update userinfo set name=?,password=? where id=?";
        jdbcContext.jdbcContextForUpdate(params, sql);
    }

    public void delete(Integer id) throws SQLException {
        Object[] params = new Object[] {id};
        String sql = "delete from userinfo where id=?";
        jdbcContext.jdbcContextForUpdate(params, sql);
    }

}
