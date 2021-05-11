package com.george.spider.app.Utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.logging.Logger;
import org.mybatis.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
@Data
public class JWTTokenUtils {
    private static Logger logger = LoggerFactory.getLogger(JWTTokenUtils.class);
    /** 秘钥 */
    @Value("${jwt.secret}")
    private  static String secret;
    /** 过期时间(秒) */
    @Value("${jwt.expire}")
    private static long expire;
    /**
     * 生成jwt token
     * @param userId
     */
    public static String createToken(String userId) {
        Date nowDate = new Date();
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(userId + "")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Claims getClaimByToken(String token) {
        if (StringUtils.isEmpty(token)) {
            return null;
        }
        String[] header = token.split("Bearer");
        token = header[1];
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        }catch (Exception e){
            System.out.println("bug"+e);
            return null;
        }
    }
    /**
     * token是否过期
     * @return true：过期
     */
    public static boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }
}

//
//@RestController
//public class JwtController {
//    @Autowired
//    private JwtToken jwtToken;
//    @PostMapping("/login")
//    public String login(User user) {
//// 1. 验证用户名和密码
//// 2. 验证成功生成token
//        Long userId = 666L;
//        String token = jwtToken.generateToken(userId);
//        return token;
//    }
//    @GetMapping("/getUserInfo")
//    public String getUserInfo(@RequestHeader("Authorization") String authHeader) throws AuthenticationException {
//// 黑名单token
//        List<String> blacklistToken = Arrays.asList("禁止访问的token");
//        Claims claims = jwtToken.getClaimByToken(authHeader);
//        if (claims == null || JwtToken.isTokenExpired(claims.getExpiration()) || blacklistToken.contains(authHeader)) {
//            throw new AuthenticationException("token 不可用");
//        }
//        String userId = claims.getSubject();
//// 根据用户id获取接口数据返回接口
//        return userId;
//    }
//}