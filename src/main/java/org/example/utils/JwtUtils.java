package org.example.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.example.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtils {
    private final static Logger logger  = LoggerFactory.getLogger(JwtUtils.class);
     private volatile static JwtUtils singleJwtUtils = null;
    private static InputStream inputStream = Thread.currentThread().getContextClassLoader().getResourceAsStream("jwt.jks"); // 寻找证书文件
    private static PrivateKey privateKey = null;
    private static PublicKey publicKey = null;
    static { // 将证书文件里边的私钥公钥拿出来
        try {
            KeyStore keyStore = KeyStore.getInstance("JKS"); // java key store 固定常量
            keyStore.load(inputStream, "mengma".toCharArray());
            privateKey = (PrivateKey) keyStore.getKey("jwt", "mengma".toCharArray()); // jwt 为 命令生成整数文件时的别名
            publicKey = keyStore.getCertificate("jwt").getPublicKey();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * 使用私钥加密 token
     *
     * @param:
     * @return:
     * @auther: Tangzhiqiang
     * @date: 2019/1/13 20:43
     */
    private  JwtUtils (){};
    public static  JwtUtils  getSingleJwtUtils () {
        if (singleJwtUtils == null) {
            synchronized (JwtUtils.class){
                if (singleJwtUtils == null) {
                    singleJwtUtils = new JwtUtils();
                }
            }
        }
        return singleJwtUtils;
    }
    public static String generateToken(String subject, int expirationSeconds) {
        return Jwts.builder()
                .setClaims(null)
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + expirationSeconds * 1000))
                .signWith(SignatureAlgorithm.RS256, privateKey)
                .compact();
    }

    /**
     *
     * 不使用公钥私钥 加密token
     *
     * @param:
     * @return:
     * @auther: Tangzhiqiang
     * @date: 2019/1/13 20:41
     */
    public static String generateToken(String subject, int expirationSeconds, String salt) {
        return Jwts.builder()
                .setClaims(null)
                .setSubject(subject)
                .setExpiration(new Date(System.currentTimeMillis() + expirationSeconds * 1000))
                .signWith(SignatureAlgorithm.HS512, salt) // 不使用公钥私钥
                .compact();
    }

    /**
     *
     * 通过 公钥解密token
     *
     * @param:
     * @return:
     * @auther:
     * @date: 2019/1/13 20:40
     */
    public static Map parseToken(String token) {
        String subject = null;
        Map result = new HashMap();
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(publicKey)
                    .parseClaimsJws(token).getBody();
            subject = claims.getSubject();
            Date date = claims.getExpiration();
            result.put("subject",subject);
            result.put("isValid",date.after(new Date()));
        } catch (Exception e) {
            logger.error(e.getMessage());
            logger.error("解析出错 {}",e);
        }
        return result;
    }
    public static Claims parseTokenClaims(String token) {
        Claims claims = null;
        try {
             claims = Jwts.parser()
                    .setSigningKey(publicKey)
                    .parseClaimsJws(token).getBody();

        } catch (Exception e) {
        }
        return claims;
    }

    /**
     *
     * 不嘛通过 公钥解密token
     *
     * @param:
     * @return:
     * @auther: Tangzhiqiang
     * @date: 2019/1/13 20:40
     */
    public static String parseToken(String token,String salt) {
        String subject = null;
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(salt) // 不使用公钥私钥
                    .parseClaimsJws(token).getBody();
            subject = claims.getSubject();
        } catch (Exception e) {
        }
        return subject;
    }

}
