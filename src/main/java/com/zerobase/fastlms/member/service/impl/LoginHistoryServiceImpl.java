package com.zerobase.fastlms.member.service.impl;

import com.zerobase.fastlms.admin.dto.LoginHistoryDto;
import com.zerobase.fastlms.admin.mapper.LoginHistoryMapper;
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
    private final LoginHistoryMapper loginHistoryMapper;

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
    public List<LoginHistoryDto> loginHistory(String userId) {
        List<LoginHistoryDto> list = loginHistoryMapper.selectList(userId);
        return list;
    }

    @Override
    public long getCount(String userId) {
        long count = loginHistoryMapper.selectListCount(userId);
        return count;
    }
}
