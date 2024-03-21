package leeyeongjae.yryrserver.manga.domain;


import jakarta.persistence.*;
import leeyeongjae.yryrserver.artist.domain.Artist;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "boards")
@Getter
@RequiredArgsConstructor
public class Manga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manga_id", nullable = false)
    private Integer mangaId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id")
    private Artist artist;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "content", length = 1000, nullable = true)
    private String content;

    @Builder
    public Manga(Artist artist,String name, String content) {
        this.artist=artist;
        this.name=name;
        this.content = content;
    }
}
