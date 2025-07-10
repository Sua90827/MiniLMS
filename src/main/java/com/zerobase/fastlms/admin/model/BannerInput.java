package com.zerobase.fastlms.admin.model;

import lombok.Data;

@Data
public class BannerInput {
    long id;

    String subject;    // 배너명
    String imgPath;
    String fileName;
    String urlFileName;

    String linkUrl;
    String openWay;

    int orderNum;
    int display;

    String uploadDateText;
    String updateDateText;

    // 파일 업로드 처리용
    String filename;
    String urlFilename;

     String idList; // 삭제할 ID 리스트 등
}
