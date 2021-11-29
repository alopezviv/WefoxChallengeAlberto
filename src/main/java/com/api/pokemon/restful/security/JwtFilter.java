package com.api.pokemon.restful.security;

import com.api.pokemon.restful.YAMLConfig;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
@Component
public class JwtFilter extends OncePerRequestFilter {
    @Autowired
    YAMLConfig yamlConfig;
    private final String HEADER = "Authorization";
    private final String PREFIX = "Bearer ";
    private final String SECRET = "%D*G-KaPdRgUkXp2s5v8y/B?E(H+MbQe";
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {

        try {
            if(existeJWTToken(request, response)) {
                Claims claims = validateToken(request);

                if(claims.getExpiration() != null) {
                    setUpSpringAuthentication(claims);
                }else {
                    SecurityContextHolder.clearContext();
                }
            }else {
                SecurityContextHolder.clearContext();
            }
            chain.doFilter(request,response);
        }catch(ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            ((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN,
                    e.getMessage());
        }

    }
    private Claims validateToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(yamlConfig.getHeaderString()).replace(yamlConfig.getTokenPrefix(), "");
        return Jwts.parser().setSigningKey(yamlConfig.getSecret().getBytes()).parseClaimsJws(jwtToken).getBody();
    }
    private void setUpSpringAuthentication(Claims claims) {

        List<GrantedAuthority> authorities = new ArrayList<>();

        UsernamePasswordAuthenticationToken auth =
                new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
                        authorities);
        SecurityContextHolder.getContext().setAuthentication(auth);
    }
    private boolean existeJWTToken(HttpServletRequest request, HttpServletResponse response) {
        String authenticationHeader = request.getHeader(yamlConfig.getHeaderString());


        return authenticationHeader != null && authenticationHeader.startsWith(yamlConfig.getTokenPrefix());


    }
}
