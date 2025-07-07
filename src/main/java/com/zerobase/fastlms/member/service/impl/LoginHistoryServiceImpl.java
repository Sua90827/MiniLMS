package com.zerobase.fastlms.member.service.impl;

import com.zerobase.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.member.entity.LoginHistory;
import com.zerobase.fastlms.member.repository.LoginHistoryRepository;
import com.zerobase.fastlms.member.service.LoginHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginHistoryServiceImpl implements LoginHistoryService {

    private final LoginHistoryRepository loginHistoryRepository;

    @Override
    public void record(String userId, String ip, String userAgent) {
        LoginHistory loginHistory = LoginHistory.builder()
                .userId(userId)
                .userIp(ip)
                .userAgent(userAgent)
                .signInDate(LocalDateTime.now())
                .build();

        loginHistoryRepository.save(loginHistory);
    }

    @Override
    public String getSignInDate(List<MemberDto> members) {
        for(MemberDto member : members){

        }
        return "";
    }
}
