package service.impl;


import entity.Slot;
import entity.User;
import service.RankingStrategy;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Queue;

public class SearchRankingStrategy implements RankingStrategy {
    @Override
    public Queue<User> rank(Queue<User> waitlist) {
        return waitlist;
    }

    @Override
    public List<Slot> getShowsOnStartTime(List<Slot> slots) {
        Collections.sort(slots, Comparator.comparing(Slot::getStartTime));
        return slots;
    }
}
