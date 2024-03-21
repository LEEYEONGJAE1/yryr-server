package leeyeongjae.yryrserver.manga.domain.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MangaResponseDto {
    private Integer boardId;
    private String name;
    private String content;
}
