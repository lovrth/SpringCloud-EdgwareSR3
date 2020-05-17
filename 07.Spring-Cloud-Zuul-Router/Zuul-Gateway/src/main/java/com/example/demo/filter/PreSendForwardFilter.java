package com.example.demo.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * 自定义Zuul过滤器 继承ZuulFilter
 */
@Component
public class PreSendForwardFilter extends ZuulFilter {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /** 对应Zuul生命周期的四个阶段：pre、post、route和error */
    @Override
    public String filterType() {
        return "pre";
    }

    /** 过滤器的优先级，数字越小，优先级越高 */
    @Override
    public int filterOrder() {
        return 1;
    }

    /** 方法返回boolean类型，true时表示是否执行该过滤器的run方法，false则表示不执行 */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /** 过滤器的过滤逻辑 */
    @Override
    public Object run() {
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();
        String host = request.getRemoteHost();
        String method = request.getMethod();
        String uri = request.getRequestURI();
        log.info("请求URI：{}，HTTP Method：{}，请求IP：{}", uri, method, host);
        return null;
    }
}
