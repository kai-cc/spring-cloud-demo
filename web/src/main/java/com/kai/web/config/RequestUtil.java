package com.kai.web.config;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

public class RequestUtil {

   public static HttpEntity<MultiValueMap<String, String>> setCookie(HttpServletRequest req){
        //创建Http头信息对象
        HttpHeaders headers = new HttpHeaders();
        //创建集合保存cookie信息
        List<String> cookies = new ArrayList<>();
        //定义变量保存session的键
        String sessionkey=null;
        //遍历request中的cookies取出session键
        Cookie[] httpcookies=req.getCookies();
        for (Cookie cookie:httpcookies){
            if(cookie.getName().equals("SESSION")){
                sessionkey=cookie.getValue();
            }
        }
        //将session键保存到cookie中
        cookies.add("SESSION="+sessionkey+";Path=/; HttpOnly");
        //将cookie存入头部
        headers.put(HttpHeaders.COOKIE,cookies);
        //请求的参数
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        //封装参数和cookie
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        return request;
   }

}
