package leeyeongjae.yryrserver.episode.domain;

import leeyeongjae.yryrserver.manga.domain.Manga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface EpisodeRepository extends JpaRepository<Episode, Integer> {
    List<Episode> findByManga(Manga manga);
}
