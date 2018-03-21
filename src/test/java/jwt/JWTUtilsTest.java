package jwt;

import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.UUID;

public class JWTUtilsTest {

    @Test
    public void generateJWT() throws UnsupportedEncodingException {
        String secret = "123456";
        JWTHeader header = new JWTHeader();
        JWTPayload payload = new JWTPayload();
        payload.setIss("Yeager");
        payload.setIat(new Date());
        payload.setExp(new Date());
        payload.setNbf(new Date());
        payload.setJti(String.valueOf(UUID.randomUUID()));


        String jwt = JWTUtils.generateJWT(header, payload, secret);
        System.out.println(jwt);
    }


    @Test
    public void verifyToken() throws UnsupportedEncodingException {
        String secret = "123456";
        JWTHeader header = new JWTHeader();
        JWTPayload payload = new JWTPayload();
        payload.setIss("Yeager");
        payload.setIat(new Date());
        payload.setExp(new Date());
        payload.setNbf(new Date());
        payload.setJti(String.valueOf(UUID.randomUUID()));


        String jwt = JWTUtils.generateJWT(header, payload, secret);

        DecodedJWT decodedJWT = null;
        try {
            decodedJWT = JWTUtils.verifyToken(jwt, "123456");
        } catch (TokenExpiredException tokenExpired) {
            System.out.println("token过期");
            tokenExpired.printStackTrace();
        } catch (InvalidClaimException invalidClaim) {
            System.out.println("无效请求");
            invalidClaim.printStackTrace();
        } catch (SignatureVerificationException signatureVerification) {
            System.out.println("无效签名");
            signatureVerification.printStackTrace();
        } catch (JWTVerificationException jwtVerification) {
            System.out.println("JWT校验失败");
            jwtVerification.printStackTrace();
        }

        System.out.println("token : " + decodedJWT.getToken());
        System.out.println("header : " + decodedJWT.getHeader());
        System.out.println("payload : " + decodedJWT.getPayload());
        System.out.println("signature : " + decodedJWT.getSignature());
    }
}