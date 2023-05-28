package com.example.MappingTask.JWTTokens;

import com.example.MappingTask.Entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class GenerateTokens {

      private static  final String secretKey = "THis Is Private Key";
      Long duration = 60L;
      Long takenTime = System.currentTimeMillis();
      Long expiredTime  = duration+takenTime*1000;
      Date issuedAt  = new Date(takenTime);
      Date expiredAt = new Date(expiredTime);

      public String generateToken(UserEntity userEntity){
          Claims claims = Jwts.claims().setIssuer("admin").setIssuedAt(issuedAt).setExpiration(expiredAt);
          return Jwts.builder().setClaims(claims).signWith(SignatureAlgorithm.HS384,secretKey).compact();
      }

      public Claims verifyToken(String authorization) throws Exception {
          try {
              Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authorization).getBody();
              return claims;

          }catch (Exception e){
              throw new UnsupportedOperationException("Unauthorized Token Verification");
          }
      }
}