package leeyeongjae.yryrserver.manga.controller;

import leeyeongjae.yryrserver.manga.domain.MangaService;
import leeyeongjae.yryrserver.manga.domain.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/manga")
public class MangaController {

    private final MangaService mangaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MangaCreateResponseDto createManga(@RequestBody MangaCreateRequestDto mangaCreateRequestDto) {
        return mangaService.createManga(mangaCreateRequestDto);
    }

    @GetMapping(value = "/{mangaId}")
    public MangaResponseDto getManga(@PathVariable Integer mangaId) {
        return mangaService.getManga(mangaId);
    }

    @GetMapping(value = "/artist/{artistId}")
    public List<MangaResponseDto> getMangaListByArtistId(@PathVariable Integer artistId) {
        return mangaService.getMangaListByArtistId(artistId);
    }

    @GetMapping(value = "/list")
    public List<MangaResponseDto> getAllMangaList(){
        return mangaService.getAllMangaList();
    }

    @GetMapping(value="/search/title/{keyword}")
    public List<MangaResponseDto> getMangaListByTitle(@PathVariable("keyword") String keyword) {
        return mangaService.getMangaListByTitle(keyword);
    }

    @PutMapping(value = "/{mangaId}")
    public void updateManga(@PathVariable Integer mangaId, @RequestBody MangaUpdateRequestDto mangaUpdateRequestDto) {
        mangaService.updateManga(mangaId, mangaUpdateRequestDto);
    }

    @DeleteMapping(value = "/{mangaId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteEpisode(@PathVariable Integer mangaId) {
        mangaService.deleteManga(mangaId);
    }
}
