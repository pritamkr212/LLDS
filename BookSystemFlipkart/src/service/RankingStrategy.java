package service;


import entity.Show;
import entity.Slot;
import entity.User;

import java.util.List;
import java.util.Queue;

/**
 * The interface Ranking strategy.
 */
public interface RankingStrategy {
    /**
     * Rank queue.
     *
     * @param waitlist the waitlist
     * @return the queue
     */
    Queue<User> rank(Queue<User> waitlist);

    /**
     * Gets shows on start time.
     *
     * @param slots the slots
     * @return the shows on start time
     */
    List<Slot> getShowsOnStartTime(List<Slot> slots);
}
