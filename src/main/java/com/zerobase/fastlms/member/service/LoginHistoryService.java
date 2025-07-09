package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.admin.dto.LoginHistoryDto;

import java.util.List;

public interface LoginHistoryService{
    void record(String userId, String ip, String userAgent);

    List<LoginHistoryDto> loginHistory(String userId);

    long getCount(String userId);
}
