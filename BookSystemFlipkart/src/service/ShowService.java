package service;

import entity.Show;
import enums.GenreType;

/**
 * The interface Show service.
 */
public interface ShowService {
    /**
     * Create show.
     *
     * @param userName  the user name
     * @param showName  the show name
     * @param genreType the genre type
     */
    public void createShow(String userName, String showName, GenreType genreType);

    /**
     * Gets show.
     *
     * @param showName the show name
     * @return the show
     */
    public Show getShow(String showName);
}
