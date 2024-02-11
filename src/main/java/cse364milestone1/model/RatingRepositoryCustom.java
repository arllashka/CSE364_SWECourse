package cse364milestone1.model;

import java.util.List;

public interface RatingRepositoryCustom {
    public List<Rating> sampleRatingsByUserId(String[] userIds, int size);
}
