package leeyeongjae.yryrserver.episode.domain.exception;

import leeyeongjae.yryrserver.common.exception.NotFoundException;

public class EpisodeNotFoundException extends NotFoundException {
    public EpisodeNotFoundException(String message) {
        super(message);
    }
}
