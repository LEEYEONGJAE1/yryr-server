package leeyeongjae.yryrserver.manga.domain.dto;

import leeyeongjae.yryrserver.manga.domain.Manga;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MangaResponseDto {
    private Integer mangaId;
    private String title;
    private String content;

    public static MangaResponseDto from(Manga manga) {
        return MangaResponseDto.builder()
                .mangaId(manga.getMangaId())
                .title(manga.getTitle())
                .content(manga.getContent())
                .build();
    }
}
