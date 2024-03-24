package leeyeongjae.yryrserver.episode.controller;

import leeyeongjae.yryrserver.episode.domain.EpisodeService;
import leeyeongjae.yryrserver.episode.domain.dto.EpisodeCreateRequestDto;
import leeyeongjae.yryrserver.episode.domain.dto.EpisodeCreateResponseDto;
import leeyeongjae.yryrserver.episode.domain.dto.EpisodeResponseDto;
import leeyeongjae.yryrserver.episode.domain.dto.EpisodeUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/episode")
public class EpisodeController {
    private final EpisodeService episodeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EpisodeCreateResponseDto createEpisode(@RequestBody EpisodeCreateRequestDto episodeCreateRequestDto) {
        return episodeService.createEpisode(episodeCreateRequestDto);
    }

    @GetMapping(value = "/{episodeId}")
    public EpisodeResponseDto getEpisode(@PathVariable Integer episodeId) {
        return episodeService.getEpisode(episodeId);
    }

    @GetMapping(value = "/manga/{mangaId}")
    public List<EpisodeResponseDto> getEpisodeListByMangaId(@PathVariable Integer mangaId) {
        return episodeService.getEpisodeListByMangaId(mangaId);
    }

    @PutMapping(value = "/{episodeId}")
    public void updateEpisode(@PathVariable Integer episodeId, @RequestBody EpisodeUpdateRequestDto episodeUpdateRequestDto) {
        episodeService.updateEpisode(episodeId, episodeUpdateRequestDto);
    }

    @DeleteMapping(value = "/{episodeId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEpisode(@PathVariable Integer episodeId) {
        episodeService.deleteEpisode(episodeId);
    }
}