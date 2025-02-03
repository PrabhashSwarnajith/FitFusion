package lk.fitfusion.fitfusion_api.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.DecodingException;
import io.jsonwebtoken.security.Keys;
import lk.fitfusion.fitfusion_api.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {


    private static final long ACCESS_TOKEN_EXPIRATION_TIME = 7 * 24 * 60 * 60 * 1000; // 7 days in milliseconds
    private static final long REFRESH_TOKEN_EXPIRATION_TIME = 14 * 24 * 60 * 60 * 1000;
    private static final String SECRET_KEY = "404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970";

    public String extractUsername(String token) {
        if (token.startsWith("Bearer ")) {
            token = token.substring(7); // Remove "Bearer " prefix
        }
        return extractClaim(token, Claims::getSubject);
    }

    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public boolean isTokenValid(String token, UserDetails user) {
        final String username = extractUsername(token);
        final String role = extractClaim(token, claims -> claims.get("role", String.class));
        return (username.equals(user.getUsername())) && !isTokenExpired(token) && user.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals(role));
    }

    private boolean isTokenExpired(String token) {
        Date expiration = extractExpiration(token);
        return expiration != null && expiration.before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public String generateToken(UserDetails userDetails) {
        if (userDetails instanceof User) {
            User user = (User) userDetails;
            return Jwts
                    .builder()
                    .setSubject(user.getUsername())
                    .claim("role", user.getRole().name()) // Use user's role
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_EXPIRATION_TIME)) // Set expiration using ACCESS_TOKEN_EXPIRATION_TIME constant
                    .signWith(getSignInKey())
                    .compact();
        } else {
            // Handle if userDetails is not an instance of User (or your custom User class)
            throw new IllegalArgumentException("UserDetails must be an instance of User.");
        }
    }

    public String generateRefreshToken(Map<String, Object> extractClaim, UserDetails userDetails) {
        if (userDetails instanceof User) {
            User user = (User) userDetails;
            return Jwts
                    .builder()
                    .setClaims(extractClaim)
                    .setSubject(user.getUsername())
                    .claim("role", user.getRole().name()) // Use user's role
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_EXPIRATION_TIME))
                    .signWith(getSignInKey())
                    .compact();
        } else {
            // Handle if userDetails is not an instance of User (or your custom User class)
            throw new IllegalArgumentException("UserDetails must be an instance of User.");
        }


    }
            private SecretKey getSignInKey() {
            byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
            return Keys.hmacShaKeyFor(keyBytes);
        }
}




