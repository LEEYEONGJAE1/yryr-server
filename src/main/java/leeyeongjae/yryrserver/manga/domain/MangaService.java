package leeyeongjae.yryrserver.manga.domain;

import jakarta.transaction.Transactional;
import leeyeongjae.yryrserver.artist.domain.Artist;
import leeyeongjae.yryrserver.artist.domain.ArtistRepository;
import leeyeongjae.yryrserver.artist.exception.ArtistNotFoundException;
import leeyeongjae.yryrserver.manga.domain.dto.MangaCreateRequestDto;
import leeyeongjae.yryrserver.manga.domain.dto.MangaCreateResponseDto;
import leeyeongjae.yryrserver.manga.domain.dto.MangaResponseDto;
import leeyeongjae.yryrserver.manga.domain.dto.MangaUpdateRequestDto;
import leeyeongjae.yryrserver.manga.domain.exception.MangaNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;


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
                    .title(mangaCreateRequestDto.getTitle())
                    .content(mangaCreateRequestDto.getContent())
                    .build()
            ).getMangaId()).build();
    }

    @Transactional
    public MangaResponseDto getManga(Integer mangaId) {
        Manga manga=mangaRepository.findById(mangaId)
                .orElseThrow(()-> new MangaNotFoundException("만화를 찾을 수 없습니다."));

        return MangaResponseDto.from(manga);
    }

    @Transactional
    public List<MangaResponseDto> getMangaListByArtistId(Integer artistId) {
        Artist artist=artistRepository.findById(artistId)
                .orElseThrow(() -> new ArtistNotFoundException("작가를 찾을 수 없습니다."));

        return mangaRepository.findByArtist(artist)
                .stream()
                .map(MangaResponseDto::from)
                .collect(toList());
    }

    @Transactional
    public List<MangaResponseDto> getAllMangaList() {
        return mangaRepository.findAll().stream()
                .map(MangaResponseDto::from)
                .collect(toList());
    }
    @Transactional
    public void updateManga(Integer mangaId, MangaUpdateRequestDto mangaUpdateRequestDto){
        Manga manga=mangaRepository.findById(mangaId)
                .orElseThrow(()-> new MangaNotFoundException("만화를 찾을 수 없습니다."));

        manga.updateManga(mangaUpdateRequestDto.getTitle(),mangaUpdateRequestDto.getContent());
    }

    @Transactional
    public void deleteManga(Integer mangaId){
        Manga manga=mangaRepository.findById(mangaId)
                .orElseThrow(()-> new MangaNotFoundException("만화를 찾을 수 없습니다."));

        mangaRepository.delete(manga);
    }

}
