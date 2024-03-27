package leeyeongjae.yryrserver.artist.domain;

import jakarta.transaction.Transactional;
import leeyeongjae.yryrserver.artist.domain.dto.ArtistCreateRequestDto;
import leeyeongjae.yryrserver.artist.domain.dto.ArtistCreateResponseDto;
import leeyeongjae.yryrserver.artist.domain.dto.ArtistResponseDto;
import leeyeongjae.yryrserver.artist.domain.dto.ArtistUpdateRequestDto;
import leeyeongjae.yryrserver.artist.exception.ArtistNotFoundException;
import leeyeongjae.yryrserver.manga.domain.dto.MangaResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RequiredArgsConstructor
@Service
public class ArtistService {
    private final ArtistRepository artistRepository;

    @Transactional
    public ArtistCreateResponseDto createArtist(ArtistCreateRequestDto artistCreateRequestDto) {
        return ArtistCreateResponseDto.builder()
                .artistId(artistRepository.save(
                        Artist.builder()
                                .name(artistCreateRequestDto.getName())
                                .content(artistCreateRequestDto.getContent())
                                .build()
                ).getArtistId()).build();
    }

    @Transactional
    public ArtistResponseDto getArtist(Integer artistId) {
        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new ArtistNotFoundException("작가를 찾을 수 없습니다."));

        return ArtistResponseDto.from(artist);
    }

    @Transactional
    public List<ArtistResponseDto> getAllArtist(){
        return artistRepository.findAll().stream()
                .map(ArtistResponseDto::from)
                .collect(toList());
    }
    @Transactional
    public void updateArtist(Integer artistId, ArtistUpdateRequestDto artistUpdateRequestDto) {
        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new ArtistNotFoundException("작가를 찾을 수 없습니다."));

        artist.updateArtist(artistUpdateRequestDto.getName(), artistUpdateRequestDto.getContent());
    }

    @Transactional
    public void deleteArtist(Integer artistId) {
        Artist artist = artistRepository.findById(artistId)
                .orElseThrow(() -> new ArtistNotFoundException("작가를 찾을 수 없습니다."));

        artistRepository.delete(artist);
    }
}
