package leeyeongjae.yryrserver.manga.domain.dto;

import lombok.Data;

@Data
public class MangaCreateRequestDto {
    private Integer mangaId;
    private Integer artistId;
    private String name;
    private String content;
}
