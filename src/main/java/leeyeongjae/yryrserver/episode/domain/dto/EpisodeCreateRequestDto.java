package leeyeongjae.yryrserver.episode.domain.dto;

import lombok.Data;

@Data
public class EpisodeCreateRequestDto {
    private Integer mangaId;
    private String title;
    private String jsonUrl;
}
