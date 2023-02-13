package kyungsu.project.projects.security;

import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;


@Service
public class TokenProvider {
	private static final String SECURITY_KEY = "security@!";
	
	public String create (String id) {
		
		Date exprTime = Date.from(Instant.now().plus(1, ChronoUnit.HOURS));
		
		return Jwts.builder()
				.signWith(SignatureAlgorithm.HS512, SECURITY_KEY)
				.setSubject(id).setIssuedAt(new Date()).setExpiration(exprTime)
				.compact();
	}
	
	
	public String validate (String token) {
		
		Claims claims = Jwts.parser().setSigningKey(SECURITY_KEY).parseClaimsJws(token).getBody();
		
		return claims.getSubject();
	}
}
