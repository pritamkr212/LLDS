package respository;



import entity.Show;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShowRepository {
    private static ShowRepository instance;
    private final Map<String, Show> shows = new HashMap<>();

    private ShowRepository() {}

    public static ShowRepository getInstance() {
        if (instance == null) {
            instance = new ShowRepository();
        }
        return instance;
    }

    public void addShow(Show show) {
        shows.put(show.getShowName(), show);
    }

    public Show getShow(String name) {
        return shows.get(name);
    }
    public List<Show> getAllShows(){
        Collection<Show> values = shows.values();
        return values.stream().toList();
    }
}


