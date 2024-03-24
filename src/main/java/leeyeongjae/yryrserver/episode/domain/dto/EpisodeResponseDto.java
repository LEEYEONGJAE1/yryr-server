package leeyeongjae.yryrserver.episode.domain.dto;

import leeyeongjae.yryrserver.episode.domain.Episode;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EpisodeResponseDto {
    private Integer episodeId;
    private String title;
    private String jsonUrl;

    public static EpisodeResponseDto from(Episode episode){
        return EpisodeResponseDto.builder()
                .episodeId(episode.getEpisodeId())
                .title(episode.getTitle())
                .jsonUrl(episode.getJsonUrl())
                .build();
    }
}
