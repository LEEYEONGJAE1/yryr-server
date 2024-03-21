package leeyeongjae.yryrserver.manga.domain;

import jakarta.transaction.Transactional;
import leeyeongjae.yryrserver.artist.domain.Artist;
import leeyeongjae.yryrserver.artist.domain.ArtistRepository;
import leeyeongjae.yryrserver.artist.exception.ArtistNotFoundException;
import leeyeongjae.yryrserver.manga.domain.dto.MangaCreateRequestDto;
import leeyeongjae.yryrserver.manga.domain.dto.MangaCreateResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class MangaService {
    private final MangaRepository mangaRepository;
    private final ArtistRepository artistRepository;

    @Transactional
    public MangaCreateResponseDto createManga(MangaCreateRequestDto mangaCreateRequestDto){
        Artist artist=artistRepository.findById(mangaCreateRequestDto.getArtistId())
                .orElseThrow(() -> new ArtistNotFoundException("작가를 찾을 수 없습니다."));

        return MangaCreateResponseDto.builder()
            .mangaId(mangaRepository.save(
                Manga.builder()
                    .artist(artist)
                    .name(mangaCreateRequestDto.getName())
                    .content(mangaCreateRequestDto.getContent())
                    .build()
            ).getMangaId()).build();
    }



}
