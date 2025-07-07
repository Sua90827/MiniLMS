package com.zerobase.fastlms.configuration;

import com.zerobase.fastlms.member.service.LoginHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Autowired
    private LoginHistoryService loginHistoryService;

    @Override
    public void onAuthenticationSuccess
            (
                    HttpServletRequest request,
                    HttpServletResponse response,
                    Authentication authentication
            )
            throws IOException, ServletException {
            String userId = authentication.getName();
            String ip = request.getRemoteAddr();
            String userAgent = request.getHeader("User-Agent");
        System.out.println("userId : " + userId + "| ip : " + ip + "| userAgent : "+userAgent);
            loginHistoryService.record(userId, ip, userAgent);

            response.sendRedirect("/"); // 로그인 후 이동할 위치
    }
}
