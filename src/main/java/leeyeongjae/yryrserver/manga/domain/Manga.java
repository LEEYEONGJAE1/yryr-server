package leeyeongjae.yryrserver.manga.domain;


import jakarta.persistence.*;
import leeyeongjae.yryrserver.artist.domain.Artist;
import leeyeongjae.yryrserver.episode.domain.Episode;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "mangas")
@Getter
@RequiredArgsConstructor
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manga_id", nullable = false)
    private Integer mangaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @OneToMany(mappedBy = "manga")
    private List<Episode> episodeList = new ArrayList<>();

    @Column(name = "title", length = 50, nullable = false)
    private String title;

    @Column(name = "thumbnail_url", length = 1000, nullable = true)
    private String thumbnailUrl;

    @Column(name = "content", length = 1000, nullable = true)
    private String content;

    @Builder
    public Manga(Artist artist, String title, String thumbnailUrl, String content) {
        this.artist = artist;
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.content = content;
    }

    public Manga updateManga(String title, String thumbnailUrl, String content) {
        this.title = title;
        this.thumbnailUrl = thumbnailUrl;
        this.content = content;
        return this;
    }
}
