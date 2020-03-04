package com.kai.zuul.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

public class MyZuulFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        //获取容器
        RequestContext ctx = RequestContext.getCurrentContext();
        //停止向下路由
//        ctx.setSendZuulResponse(false);
        //设置响应的错误编码
//        ctx.setResponseStatusCode(401);
        //设置响应的错误信息
//        ctx.setResponseBody("miss token");
        System.out.println("sessionId为："+ctx.getRequest().getSession().getId());
        return null;
    }
}
