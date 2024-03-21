package leeyeongjae.yryrserver.artist.exception;

import leeyeongjae.yryrserver.common.exception.NotFoundException;

public class ArtistNotFoundException extends NotFoundException {
    public ArtistNotFoundException(String message) {
        super(message);
    }
}
