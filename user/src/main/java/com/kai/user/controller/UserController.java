package com.kai.user.controller;

import com.kai.user.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("query-all-user")
    @HystrixCommand(fallbackMethod="fallBack")
    public List<User> queryAllUser(HttpSession session) throws InterruptedException {
        System.out.println("sessionId为："+session.getId());
        Thread.sleep(10000);
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"wukai","wukai"));
        users.add(new User(2,"xiaoming","xiaoming"));
        return users;
    }

    @PostMapping("query-all-vip")
    @HystrixCommand(fallbackMethod="fallBack2")
    public List<User> queryAllVip(HttpSession session) throws InterruptedException {
        System.out.println("sessionId为："+session.getId());
//        Thread.sleep(10000);
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1,"vip","vip"));
        return users;
    }

    public List<User> fallBack(HttpSession session){
        System.out.println("sessionId为："+session.getId());
        return new ArrayList<>();
    }

    public List<User> fallBack2(HttpSession session){
        System.out.println("sessionId为："+session.getId());
        return new ArrayList<>();
    }

}
