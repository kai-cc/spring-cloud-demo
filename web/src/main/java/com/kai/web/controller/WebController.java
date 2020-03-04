package com.kai.web.controller;

import com.kai.web.config.RequestUtil;
import com.kai.web.entity.User;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class WebController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("query-vip-user")
    public List<User> queryAllVip(HttpServletRequest request,HttpSession session){
        System.out.println("sessionId为："+session.getId());
        ResponseEntity<Object> entity = restTemplate.postForEntity("http://user/query-all-vip", RequestUtil.setCookie(request), Object.class);
        return (List<User>)entity.getBody();
    }

}
