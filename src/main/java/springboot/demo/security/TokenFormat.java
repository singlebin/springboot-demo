package springboot.demo.security;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import springboot.demo.service.GreetingService;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;

/**
 * @description:
 * @Author: wub
 * @date 2019/8/19 14:45
 */
@Component
@Slf4j
public class TokenFormat {

    /**
     * 生成token码
     * @param id
     * @param issuer
     * @param subject
     * @return
     */
//    public String createJWT(String id, String issuer, String subject){
//        // 生成签发时间
//        Date nowMillis = new Date();
//        // 设置JWT声明
//        JwtBuilder builder = Jwts.builder().setId(id)
//                // iat: jwt的签发时间
//                .setIssuedAt(nowMillis)
//                // 代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userId，roleId之类的，作为什么用户的唯一标志。
//                .setSubject(subject)
//                .setIssuer(issuer)
//                // 设置签名使用的签名算法和签名使用的秘钥
//                .signWith(securityConfig.processedSignatureAlgorithm(),
//                        new SecretKeySpec(DatatypeConverter.parseBase64Binary(securityConfig.getSecret()), securityConfig.processedSignatureAlgorithm().getJcaName()));
//
//        // 设置过期时间
//        builder.setExpiration(new Date(nowMillis.getTime() + securityConfig.getExpireDate()));
//
//        // 构建JWT并将其序列化为紧凑的URL安全字符串
//        return builder.compact();
//    }

}
