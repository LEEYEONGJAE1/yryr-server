package leeyeongjae.yryrserver.artist.domain.dto;

import lombok.Data;

@Data
public class ArtistUpdateRequestDto {
    private Integer artistId;
    private String name;
    private String content;
}
