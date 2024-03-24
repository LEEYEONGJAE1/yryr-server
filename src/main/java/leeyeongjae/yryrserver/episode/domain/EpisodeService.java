package leeyeongjae.yryrserver.episode.domain;

import jakarta.transaction.Transactional;
import leeyeongjae.yryrserver.episode.domain.dto.EpisodeCreateRequestDto;
import leeyeongjae.yryrserver.episode.domain.dto.EpisodeCreateResponseDto;
import leeyeongjae.yryrserver.episode.domain.dto.EpisodeResponseDto;
import leeyeongjae.yryrserver.episode.domain.dto.EpisodeUpdateRequestDto;
import leeyeongjae.yryrserver.episode.domain.exception.EpisodeNotFoundException;
import leeyeongjae.yryrserver.manga.domain.Manga;
import leeyeongjae.yryrserver.manga.domain.MangaRepository;
import leeyeongjae.yryrserver.manga.domain.exception.MangaNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;
@RequiredArgsConstructor
@Service
public class EpisodeService {
    private final EpisodeRepository episodeRepository;
    private final MangaRepository mangaRepository;

    @Transactional
    public EpisodeCreateResponseDto createEpisode(EpisodeCreateRequestDto episodeCreateRequestDto){
        Manga manga=mangaRepository.findById(episodeCreateRequestDto.getMangaId())
                .orElseThrow(()-> new MangaNotFoundException("만화를 찾을 수 없습니다."));

        return EpisodeCreateResponseDto.builder()
                .episodeId(episodeRepository.save(
                        Episode.builder()
                                .manga(manga)
                                .title(episodeCreateRequestDto.getTitle())
                                .jsonUrl(episodeCreateRequestDto.getJsonUrl())
                                .build()
                ).getEpisodeId()).build();
    }

    @Transactional
    public void updateEpisode(Integer episodeId, EpisodeUpdateRequestDto episodeUpdateRequestDto){
        Episode episode=episodeRepository.findById(episodeId)
                .orElseThrow(()-> new EpisodeNotFoundException("에피소드를 찾을 수 없습니다."));

        episode.updateEpisode(episodeUpdateRequestDto.getTitle(), episodeUpdateRequestDto.getJsonUrl());
    }

    @Transactional
    public void deleteEpisode(Integer episodeId){
        Episode episode=episodeRepository.findById(episodeId)
                .orElseThrow(()-> new MangaNotFoundException("에피소드를 찾을 수 없습니다."));

        episodeRepository.delete(episode);
    }
    @Transactional
    public EpisodeResponseDto getEpisode(Integer episodeId) {
        Episode episode=episodeRepository.findById(episodeId)
                .orElseThrow(()-> new MangaNotFoundException("에피소드를 찾을 수 없습니다."));

        return EpisodeResponseDto.from(episode);
    }

    @Transactional
    public List<EpisodeResponseDto> getEpisodeListByMangaId(Integer mangaId) {
        Manga manga=mangaRepository.findById(mangaId)
                .orElseThrow(()-> new MangaNotFoundException("만화를 찾을 수 없습니다."));

        return episodeRepository.findByManga(manga)
                .stream()
                .map(episode -> EpisodeResponseDto.from(episode))
                .collect(toList());
    }
}
