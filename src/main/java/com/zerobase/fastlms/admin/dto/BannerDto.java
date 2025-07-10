package com.zerobase.fastlms.admin.dto;

import com.zerobase.fastlms.admin.entity.Banner;
import com.zerobase.fastlms.course.dto.CourseDto;
import com.zerobase.fastlms.course.entity.Course;
import lombok.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class BannerDto {
    Long id;
    String subject;
    String imgPath;
    String fileName;
    String urlFileName;

    String linkUrl;//링크주소
    String openWay;//오픈 방법 (S: _self, B: _blank)

    int orderNum;//정렬 순서
    int display;//공개 여부 (0: 비공개, 1: 공개)
    LocalDateTime uploadDate;//업로드 날짜
    LocalDateTime updateDate;//업데이트 날짜

    public static BannerDto of(Banner banner) {
        return BannerDto.builder()
                .id(banner.getId())
                .subject(banner.getSubject())
                .imgPath(banner.getImgPath())
                .fileName(banner.getFileName())
                .urlFileName(banner.getUrlFileName())
                .linkUrl(banner.getLinkUrl())
                .openWay(banner.getOpenWay())
                .orderNum(banner.getOrderNum())
                .display(banner.getDisplay())
                .uploadDate(banner.getUploadDate())
                .updateDate(banner.getUpdateDate())
                .build();
    }

    public String getUploadDateText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return uploadDate != null ? uploadDate.format(formatter) : "";
    }
}
