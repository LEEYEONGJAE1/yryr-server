package leeyeongjae.yryrserver.manga.domain.dto;

import lombok.Data;

@Data
public class MangaUpdateRequestDto {
    private String title;
    private String content;
    private String thumbnailUrl;
}
