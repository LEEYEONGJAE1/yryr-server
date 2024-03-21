package leeyeongjae.yryrserver.artist.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Integer> {
    List<Artist> findbyName(String name);
}
