package leeyeongjae.yryrserver.manga.domain.dto;

import lombok.Data;

@Data
public class MangaUpdateRequestDto {
    private Integer mangaId;
    private Integer artistId;
    private String title;
    private String content;
}
