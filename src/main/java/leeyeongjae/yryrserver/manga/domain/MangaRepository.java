package leeyeongjae.yryrserver.manga.domain;

import leeyeongjae.yryrserver.artist.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MangaRepository  extends JpaRepository<Manga, Integer> {
    List<Manga> findbyName(String name);
    List<Manga> findByArtist(Artist artist);
}
