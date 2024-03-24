package leeyeongjae.yryrserver.manga.domain.dto;

import lombok.Data;

@Data
public class MangaCreateRequestDto {
    private Integer artistId;
    private String title;
    private String content;
}
