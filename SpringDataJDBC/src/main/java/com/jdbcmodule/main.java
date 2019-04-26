/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbcmodule;

import com.jdbcmodule.interfaces.UserDAOInterface;
import com.spring.dao.DAO;
import com.spring.entities.User;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Amr Elkady
 */
public class main {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
        User user = (User) ctx.getBean("user");
        user.setAddress("haram,giza");
        user.setRegistrationDate(new Date());
        user.setUserName("AmrSaber");
        user.setPassword("1235");
        user.setEmail("amrelkady93@gmail.com");
        UserDAOInterface dao = (UserDAOInterface) ctx.getBean("dao");
        // dao.deleteById(156);
        // System.out.println(dao.getUserById(156).getAddress());
//       dao.getAll().forEach(u->System.out.println(u.));
        System.out.print(dao.count());

    }

}
