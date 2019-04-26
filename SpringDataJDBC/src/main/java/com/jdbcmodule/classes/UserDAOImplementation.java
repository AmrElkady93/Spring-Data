/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbcmodule.classes;

import com.jdbcmodule.utilities.UserExtractor;
import com.jdbcmodule.interfaces.UserDAOInterface;
import com.spring.entities.User;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

/**
 *
 * @author Amr Elkady
 */
@Service
public class UserDAOImplementation implements UserDAOInterface {

    @Autowired
    DataSource dataSource;
    JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public int count() {
        String sql = "select count(*) from user " ;
        return jdbcTemplate.queryForObject(sql, Integer.class);
    }

    public List<User> getAll() {
        String sql = "select * from  user" ;
        //Object[] param=new Object[]{id};
        List<User> users = jdbcTemplate.query(sql, new UserExtractor());
        return users;
    }

    public <ID> User getRecordByID(ID id) {
        String sql = "select * from user where id = ?";
        Object[] param = new Object[]{id};
        User user = jdbcTemplate.queryForObject(sql, param, new BeanPropertyRowMapper<>(User.class));
        return user;
    }

    public User insert(User entity) {
        String sql = "insert into User(email,address,phone,mobile,date_of_birth,registration_date,user_name,password,full_name) "
                + "values(?,?,?,?,?,?,?,?,?)";
        Object[] param = new Object[]{entity.getEmail(), entity.getAddress(),
            entity.getPhone(), entity.getMobile(),
            entity.getDateOfBirth(), entity.getRegistrationDate(),
            entity.getUserName(), entity.getPassword(), entity.getFullName()
        };
        jdbcTemplate.update(sql, param);
        return entity;
    }

    public User update(User entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public <ID> void deleteByID(ID id) {
        String sql = "delete from user where id = ?";
        Object[] arg = new Object[]{id};
        jdbcTemplate.update(sql, arg);
    }

    public <Obj> void deleteByObject(Obj entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
