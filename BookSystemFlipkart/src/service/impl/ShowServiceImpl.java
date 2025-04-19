package service.impl;


import entity.Show;
import entity.User;
import enums.GenreType;
import enums.UserType;
import respository.ShowRepository;
import respository.UserRepository;
import service.ShowService;

/**
 * The type Show service.
 */
public class ShowServiceImpl implements ShowService {
    private final ShowRepository showRepository = ShowRepository.getInstance();
    private final UserRepository userRepository = UserRepository.getInstance();

    public void createShow(String userName, String showName, GenreType genreType) {
        User user = userRepository.getUser(userName);
        if (user == null || user.getUserType() != UserType.ORGANIZER) {
            throw new IllegalArgumentException("Only ORGANIZER can create shows.");
        }
        if (showRepository.getShow(showName) != null) {
            throw new IllegalArgumentException("Show already exists with name: " + showName);
        }
        Show show = new Show(showName, genreType);
        showRepository.addShow(show);
    }

    public Show getShow(String showName) {
        return showRepository.getShow(showName);
    }
}
