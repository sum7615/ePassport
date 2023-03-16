package com.passport.config;

import java.io.IOException;


import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.passport.serviceImpl.JpaUserDetailsService;

import jakarta.annotation.Nonnull;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
@Nonnull
public class JwtAuthFilter extends OncePerRequestFilter {

    private final JpaUserDetailsService userDetailsService;
    private final JwtUtils jwtUtils;
    
    

    public JwtAuthFilter(JpaUserDetailsService userDetailsService, JwtUtils jwtUtils) {
		super();
		this.userDetailsService = userDetailsService;
		this.jwtUtils = jwtUtils;
	}




	@Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
       final String authHeader = request.getHeader(org.springframework.http.HttpHeaders.AUTHORIZATION);
        String jwtToken = null;


       if (authHeader == null || !authHeader.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            return;
       }

        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("jwt")) {
                jwtToken = cookie.getValue();
            }
        }
        if (jwtToken == null) {
            filterChain.doFilter(request, response);
            return;
        }

        String username = jwtUtils.extractUsername(jwtToken);
        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);
            if (jwtUtils.validateToken(jwtToken, userDetails)) {
                UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDetails,
                        null, userDetails.getAuthorities());
                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
