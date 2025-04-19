package service.impl;


import entity.Show;
import entity.Slot;
import enums.GenreType;
import respository.ShowRepository;
import service.RankingStrategy;
import service.SearchService;

import java.util.ArrayList;
import java.util.List;

public class SearchServiceImpl implements SearchService {
    private final ShowRepository showRepository = ShowRepository.getInstance();
    private RankingStrategy rankingStrategy = new SearchRankingStrategy();


    public void showAvailableByGenre(GenreType genreType) {
        List<Slot> availableSlots = new ArrayList<>();
        for (Show show : showRepository.getAllShows()) {
            if (show.getGenre() == genreType) {
                availableSlots.addAll(show.getSlots());
            }
        }
        List<Slot> sortedSlots = rankingStrategy.getShowsOnStartTime(availableSlots);
        for (Slot slot : sortedSlots) {
            System.out.println(slot.getShowName() + ": (" + slot.getStartTime() + ") " + slot.getAvailableCapacity());
        }
    }
}
