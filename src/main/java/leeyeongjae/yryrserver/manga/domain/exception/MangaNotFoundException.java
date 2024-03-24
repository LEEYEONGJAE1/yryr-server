package leeyeongjae.yryrserver.manga.domain.exception;

import leeyeongjae.yryrserver.common.exception.NotFoundException;

public class MangaNotFoundException extends NotFoundException {
    public MangaNotFoundException(String message) {
        super(message);
    }
}
