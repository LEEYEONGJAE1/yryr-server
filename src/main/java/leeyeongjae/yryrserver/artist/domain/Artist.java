package leeyeongjae.yryrserver.artist.domain;

import jakarta.persistence.*;
import leeyeongjae.yryrserver.manga.domain.Manga;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "artists")
@Getter
@RequiredArgsConstructor
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "artist_id", nullable = false)
    private Integer artistId;

    @OneToMany(mappedBy = "artist")
    private List<Manga> mangaList = new ArrayList<>();

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name="content", length = 1000)
    private String content;

    @Builder
    public Artist(String name,String content){
        this.name=name;
        this.content=content;
    }

    public Artist updateArtist(String name,String content){
        this.name=name;
        this.content=content;
        return this;
    }
}
