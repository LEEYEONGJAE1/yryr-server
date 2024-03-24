package leeyeongjae.yryrserver.episode.domain;

import jakarta.persistence.*;
import leeyeongjae.yryrserver.manga.domain.Manga;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "episodes")
@Getter
@RequiredArgsConstructor
public class Episode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "episode_id", nullable = false)
    private Integer episodeId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manga_id")
    private Manga manga;

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "json_url", length = 1000, nullable = false)
    private String jsonUrl;

    @Builder
    public Episode(Manga manga, String title, String jsonUrl) {
        this.manga = manga;
        this.title = title;
        this.jsonUrl = jsonUrl;
    }

    public Episode updateEpisode(String title, String jsonUrl) {
        this.title = title;
        this.jsonUrl = jsonUrl;
        return this;
    }
}