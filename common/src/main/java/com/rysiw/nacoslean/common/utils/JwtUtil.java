package com.rysiw.nacoslean.common.utils;

import com.rysiw.nacoslean.common.constant.RespCode;
import com.rysiw.nacoslean.common.vo.ResultVO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * Jwt工具类
 * @author Rysiw
 * @date 2022/2/25 16:07
 */
public class JwtUtil {

    public static String buildJwtToken(Date expire, String userId){
        return Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "Aidoo")
                .setExpiration(expire)
                .claim("id",userId)
                .compact();
    }
    public static ResultVO verifyToken(String token){
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey("Aidoo")
                    .parseClaimsJws(token)
                    .getBody();
            return ResultUtil.success();
        }catch (ExpiredJwtException e){
            //JWT到期
            return ResultUtil.custom(RespCode.AUTH_EXPIRED);
        } catch (Exception e) {
            //系统错误
            return ResultUtil.custom(RespCode.UNAUTHORIZED);
        }
    }
}
