package leeyeongjae.yryrserver.artist.controller;

import leeyeongjae.yryrserver.artist.domain.ArtistService;
import leeyeongjae.yryrserver.artist.domain.dto.ArtistCreateRequestDto;
import leeyeongjae.yryrserver.artist.domain.dto.ArtistCreateResponseDto;
import leeyeongjae.yryrserver.artist.domain.dto.ArtistResponseDto;
import leeyeongjae.yryrserver.artist.domain.dto.ArtistUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/artist")
public class ArtistController {
    private final ArtistService artistService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArtistCreateResponseDto createArtist(@RequestBody ArtistCreateRequestDto artistCreateRequestDto) {
        return artistService.createArtist(artistCreateRequestDto);
    }

    @GetMapping(value = "/{artistId}")
    public ArtistResponseDto getArtist(@PathVariable Integer artistId) {
        return artistService.getArtist(artistId);
    }

    @PutMapping(value = "/{artistId}")
    public void updateArtist(@PathVariable Integer artistId, @RequestBody ArtistUpdateRequestDto artistUpdateRequestDto) {
        artistService.updateArtist(artistId, artistUpdateRequestDto);
    }

    @DeleteMapping(value = "/{artistId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteArtist(@PathVariable Integer artistId) {
        artistService.deleteArtist(artistId);
    }
}
