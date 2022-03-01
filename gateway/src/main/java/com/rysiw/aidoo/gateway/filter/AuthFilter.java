package com.rysiw.aidoo.gateway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import com.rysiw.aidoo.common.constant.RespCode;
import com.rysiw.aidoo.common.utils.JwtUtil;
import com.rysiw.aidoo.common.utils.ResultUtil;
import com.rysiw.aidoo.common.vo.ResultVO;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 鉴权filter
 * @author Rysiw
 * @date 2022/2/25 16:36
 */
@Component
public class AuthFilter extends ZuulFilter {

    private final static String AUTH_TOKEN = "token";

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
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
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        String path = request.getServletPath();
        //访问api v1接口需要验签
        if(path.contains("/api/v1")) {
            String token = request.getHeader(AUTH_TOKEN);
            ResultVO vo = token != null ? JwtUtil.verifyToken(token) : ResultUtil.error();
            if (RespCode.SUCCESS.getCode().equals(vo.getCode())) {
                ctx.setResponseStatusCode(HttpStatus.OK.value());
                ctx.setSendZuulResponse(true);
            } else {
                ctx.setSendZuulResponse(false);
                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                ctx.setResponseBody(vo.getMsg());
            }
        }
        return null;
    }
}
