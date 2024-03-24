package leeyeongjae.yryrserver.artist.domain.dto;

import leeyeongjae.yryrserver.artist.domain.Artist;
import leeyeongjae.yryrserver.manga.domain.dto.MangaResponseDto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ArtistResponseDto {
    private Integer artistId;
    private String name;
    private String content;

    public static ArtistResponseDto from(Artist artist) {
        return ArtistResponseDto.builder()
                .artistId(artist.getArtistId())
                .name(artist.getName())
                .content(artist.getContent())
                .build();
    }
}
