//package org.example.mrdverkin.security;
//
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
//import org.springframework.stereotype.Component;
//
//import java.io.IOException;
//import java.util.Collection;
//
//@Component
//public class CustomSuccessHandler implements AuthenticationSuccessHandler {
//
//    @Override
//    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//        Collection<SimpleGrantedAuthority> authorities = (Collection<SimpleGrantedAuthority>) authentication.getAuthorities();
//
//        if (authorities.contains(new SimpleGrantedAuthority("ROLE_SELLER"))) {
//            response.sendRedirect("/home/seller");
//        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_MainInstaller"))) {
//            response.sendRedirect("/home/mainInstaller");
//        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
//            response.sendRedirect("/home/adminPanel");
//        } else {
//            response.sendRedirect("/main"); // По умолчанию, если роль не совпадает
//        }
//    }
//}
