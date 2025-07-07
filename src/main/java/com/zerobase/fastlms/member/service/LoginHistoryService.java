package com.zerobase.fastlms.member.service;

import com.zerobase.fastlms.admin.dto.MemberDto;
import com.zerobase.fastlms.member.service.impl.LoginHistoryServiceImpl;

import java.util.List;

public interface LoginHistoryService{
    void record(String userId, String ip, String userAgent);

    String getSignInDate(List<MemberDto> members);
}
