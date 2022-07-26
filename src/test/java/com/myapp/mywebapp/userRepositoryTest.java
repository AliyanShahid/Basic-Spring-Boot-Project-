package com.myapp.mywebapp;

import com.myapp.mywebapp.user.userRepository;
import org.apache.catalina.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.myapp.mywebapp.user.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class userRepositoryTest {
    @Autowired private userRepository repo ;
    @Test
    public void testaddnew() {
        user user = new user();
        user.setEmail("satti98@gmail.com");
        user.setFirstname("Aliyan");
        user.setLastname("Shahid");
        user.setPassword("Aliyan_123456");
        repo.save(user);

    }
    @Test
    public void testall()
    {
        Iterable<user> users = repo.findAll();


        for (user user : users){
            System.out.println(user);
        }
    }
    @Test
    public void updatebyid()
    {    Integer userid= 8;
        Optional<user> optionalUser = repo.findById(userid);
        user user =optionalUser.get();
        user.setEmail("Aliyan@gmial.com");
        repo.save(user);
        repo.findById(userid).get();
    }

    @Test
    public void deleteId()
    {
        Integer userId =7;
        repo.deleteById(userId);
        Optional<user> optionalUser=repo.findById(userId);

    }
      }
