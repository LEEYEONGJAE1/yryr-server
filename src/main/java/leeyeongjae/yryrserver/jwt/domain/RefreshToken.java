package leeyeongjae.yryrserver.jwt.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name = "refresh_token")
@Getter
@RequiredArgsConstructor
public class RefreshToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "token_id", nullable = false)
    private Integer tokenId;

    @Column(name="username",length = 1000, nullable = false)
    private String username;

    @Column(name="token",length = 1000, nullable = false)
    private String token;

    public RefreshToken updateToken(String token) {
        this.token = token;
        return this;
    }

    @Builder
    public RefreshToken(String username, String token) {
        this.username = username;
        this.token = token;
    }
}