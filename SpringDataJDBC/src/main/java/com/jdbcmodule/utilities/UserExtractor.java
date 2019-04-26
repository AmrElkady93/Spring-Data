/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbcmodule.utilities;

import com.spring.entities.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

/**
 *
 * @author Amr Elkady
 */
public class UserExtractor implements ResultSetExtractor<List<User>> {

    public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
        List<User> users = new ArrayList<>();
        while (rs.next()) {
            User user = new User();
            user.setAddress(rs.getString("address"));
            users.add(user);

        }

        return users;

    }

}
