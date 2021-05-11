package com.george.spider.app.Logic;

import org.springframework.stereotype.Component;

import javax.xml.bind.DatatypeConverter;
import java.util.Date;

@Component
public class JWTLogic {
    private static final String SECRET = "token";

    /**
     * 生成Token
     *
     * @param id        编号
     * @param issuer    该JWT的签发者，是否使用是可选的
     * @param subject   该JWT所面向的用户，是否使用是可选的；
     * @param ttlMillis 签发时间
     * @return token String
     */
//    public static String createJwtToken(String id, String issuer, String subject, long ttlMillis) {
//
//        // 签名算法 ，将对token进行签名
//        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//
//        // 生成签发时间
//        long nowMillis = System.currentTimeMillis();
//        Date now = new Date(nowMillis);
//
//        // 通过秘钥签名JWT
//        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET);
//        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
//
//        //创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
//        Map<String, Object> claims = new HashMap<String, Object>();
//        claims.put("userDetails", id);
//
//        // Let's set the JWT Claims
//        JwtBuilder builder = Jwts.builder().setId(id)
//                .setIssuedAt(now)
//                .setSubject(subject)
//                .setIssuer(issuer)
//                .setClaims(claims)
//                .signWith(signatureAlgorithm, signingKey);
//
//        // if it has been specified, let's add the expiration
//        if (ttlMillis >= 0) {
//            long expMillis = nowMillis + ttlMillis;
//            Date exp = new Date(expMillis);
//            builder.setExpiration(exp);
//        }
//
//        // Builds the JWT and serializes it to a compact, URL-safe string
//        return builder.compact();
//
//    }


    public void cheackToken(){

    }
}
