package com.zerobase.fastlms.admin.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
public class Banner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String subject;//배너명

    String imgPath;
    String fileName;
    String urlFileName;

    String linkUrl;//링크주소
    String openWay;//오픈 방법 (S: _self, B: _blank)

    int orderNum;//정렬 순서
    int display;//공개 여부 (0: 비공개, 1: 공개)
    LocalDateTime uploadDate;//업로드 날짜
    LocalDateTime updateDate;//업데이트 날짜

}
