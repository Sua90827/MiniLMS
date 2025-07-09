package com.zerobase.fastlms.admin.dto;

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
    String img;
    LocalDateTime uploadDate;

    public String getUploadDateText() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");
        return uploadDate != null ? uploadDate.format(formatter) : "";
    }
}
