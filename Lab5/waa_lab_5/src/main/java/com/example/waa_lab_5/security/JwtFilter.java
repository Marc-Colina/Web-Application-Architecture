package com.example.waa_lab_5.security;


import com.example.waa_lab_5.security.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;


//    @Override
//    protected void doFilterInternal(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull FilterChain filterChain) throws ServletException, IOException {
//
//        final String authorizationHeader = request.getHeader("Authorization");
//        System.out.println("I GOT HERE 1!");
//        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
//            System.out.println("I GOT HERE!");
//            String token = authorizationHeader.substring(7);
//            // VALIDATE
//            boolean isTokenValid = jwtUtil.validateToken(token);
//            String email = jwtUtil.getUsernameFromToken(token);
//
//            if (isTokenValid && SecurityContextHolder.getContext().getAuthentication() == null) {
////              GO TO DB
//                UserDetails userDetails = userDetailsService.loadUserByUsername(email);
//
//                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
//                        userDetails, null, userDetails.getAuthorities());
//
//                //STORE IN the CONTEXT
//                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authentication);
//            }
//        }
//
//        filterChain.doFilter(request, response);
//    }

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        var token = extractTokenFromRequest(request);

        if (token != null && jwtUtil.validateToken(token)) {
            SecurityContextHolder.getContext().setAuthentication(jwtUtil.getAuthentication(token));
        }

        filterChain.doFilter(request, response);
    }

    public String extractTokenFromRequest(HttpServletRequest request) {
        final String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            var token = authorizationHeader.substring(7);
            return token;
        }
        return null;
    }
}