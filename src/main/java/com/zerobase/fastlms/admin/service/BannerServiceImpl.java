package com.zerobase.fastlms.admin.service;

import com.zerobase.fastlms.admin.dto.BannerDto;
import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.admin.mapper.BannerMapper;
import com.zerobase.fastlms.admin.model.BannerInput;
import com.zerobase.fastlms.admin.model.BannerParam;
import com.zerobase.fastlms.admin.repository.BannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BannerServiceImpl implements BannerService{

    private final BannerMapper bannerMapper;
    private final BannerRepository bannerRepository;

    @Override
    public List<BannerDto> list(BannerParam parameter) {
        List<BannerDto> list = bannerMapper.selectList(parameter);
        return list;
    }

    @Override
    public BannerDto getById(long id) {
        return bannerRepository.findById(id).map(BannerDto::of).orElse(null);
    }

    @Override
    public boolean set(BannerInput parameter) {
        Optional<Banner> optionalBanner = bannerRepository.findById(parameter.getId());

        if(!optionalBanner.isPresent()){//수정할 데이터 없음
            return false;
        }

        Banner banner = optionalBanner.get();
        banner.setSubject(parameter.getSubject());
        banner.setImgPath(parameter.getImgPath());
        banner.setFileName(parameter.getFileName());// 실제 서버에 저장된 파일명
        banner.setUrlFileName(parameter.getUrlFileName());// 사용자에게 노출할 파일 URL
        banner.setLinkUrl(parameter.getLinkUrl());
        banner.setOpenWay(parameter.getOpenWay());
        banner.setOrderNum(parameter.getOrderNum());
        banner.setDisplay(parameter.getDisplay());
        banner.setUpdateDate(LocalDateTime.now());

        bannerRepository.save(banner);
        return true;
    }

    @Override
    public boolean add(BannerInput parameter) {
        Banner banner = Banner.builder()
                .subject(parameter.getSubject())
                .imgPath(parameter.getImgPath())
                .fileName(parameter.getFileName())// 실제 서버에 저장된 경로
                .urlFileName(parameter.getUrlFileName())// 웹에서 접근 가능한 경로
                .linkUrl(parameter.getLinkUrl())
                .openWay(parameter.getOpenWay())// S: _self, B: _blank
                .orderNum(parameter.getOrderNum())
                .display(parameter.getDisplay())// 1: 공개, 0: 비공개
                .uploadDate(LocalDateTime.now())
                .updateDate(LocalDateTime.now())
                .build();
        bannerRepository.save(banner);
        return true;
    }

    @Override
    public boolean del(String idList) {
        if(idList != null && idList.length() > 0){
            String[] ids = idList.split(",");
            for(String x : ids){
                long id = 0L;
                try{
                    id = Long.parseLong(x);
                }catch(Exception e){

                }

                if(id > 0){
                    bannerRepository.deleteById(id);
                }
            }
        }
        return true;
    }

    @Override
    public List<BannerDto> getBanners() {
        List<Banner> bannerList = bannerRepository.findByDisplayOrderByOrderNumAsc(1);
        // 정적 변환 메서드
        return bannerList.stream()
                .map(BannerDto::of) // 정적 변환 메서드
                .collect(Collectors.toList());
    }
}
