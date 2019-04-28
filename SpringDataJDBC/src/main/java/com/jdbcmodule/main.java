/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jdbcmodule;

import com.jdbcmodule.classes.UserDAOImplementation;
import com.jdbcmodule.configrution.Config;
import com.jdbcmodule.interfaces.UserDAOInterface;
import com.spring.dao.DAO;
import com.spring.entities.User;
import java.util.Date;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Amr Elkady
 */
public class main {

    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
        User user = ctx.getBean(User.class);
        UserDAOInterface dao = ctx.getBean(UserDAOInterface.class);
        
        user.setAddress("haram,giza");
        user.setRegistrationDate(new Date());
        user.setUserName("AmrSaber");
        user.setPassword("1235");
        user.setEmail("amrelkady93@gmail.com");
        //dao.getAll().forEach(u -> System.out.println(u.getAddress()));
        System.out.println(dao.getRecordByID(94).getEmail());
    }

}
