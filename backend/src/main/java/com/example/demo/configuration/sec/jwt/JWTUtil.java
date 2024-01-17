package com.example.demo.configuration.sec.jwt;

import com.example.demo.services.UserServiceDetails;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

@Component
@Slf4j
public class JWTUtil {
    private final String KEY = "viktor111";
    private static final long TOKEN_VALIDITY = 1800000; //30 min
    private final UserServiceDetails userDetails;


    @Autowired
    public JWTUtil(UserServiceDetails userDetails) {
        this.userDetails = userDetails;
    }

    public String generateToken(String username, List<String> roles) {
        System.out.println("Генерируем токен " + LocalDateTime.now());
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", roles);
        Date now = new Date();
        JwtBuilder m = Jwts.builder().setClaims(claims).setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + TOKEN_VALIDITY)).signWith(SignatureAlgorithm.HS512, KEY);
        //System.out.println(SignatureAlgorithm.HS512+ " "+KEY);
        JwtBuilder n = m;
        return n.compact();
    }

    public boolean validateToken(String token) {
        Jws<Claims> claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token);
        if (claims.getBody().getExpiration().before(new Date())) {
            return false;
        } else return true;
    }

    private boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDate(token);
        return expiration.before(new Date());
    }

    public String resolveToken(HttpServletRequest req) {
        String bearerToken = req.getHeader("Authorization");

        if (bearerToken != null && (bearerToken.startsWith("Bearer "))) {
            System.out.println(bearerToken);
            return bearerToken.substring(7);
        } else {
            return null;
        }
    }

    public Authentication getAuthentication(String token) {
        UserDetails ud = this.userDetails.loadUserByUsername(getUsername(token));
        return new UsernamePasswordAuthenticationToken(ud, "", ud.getAuthorities());
    }

    public String getUsername(String token) {
        return getClaim(token, Claims::getSubject);
    }

    public Date getExpirationDate(String token) {
        return getClaim(token, Claims::getExpiration);
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
        System.out.println(token+"lkj");
        //System.out.println(Jwts.parser().setSigningKey(KEY).parseClaimsJwt(token));//.parseClaimsJws(token).getBody();
        final Claims claims = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
        return claimsResolver.apply(claims);
    }
}