package service;

import enums.GenreType;

/**
 * The interface Search service.
 */
public interface SearchService {
    /**
     * Show available by genre.
     *
     * @param genreType the genre type
     */
    void showAvailableByGenre(GenreType genreType);
}
