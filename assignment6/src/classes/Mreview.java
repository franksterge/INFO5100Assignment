package classes;
import java.util.ArrayList;
import java.util.List;

public class Mreview implements Comparable<Mreview> {
    private String title;
    private List<Integer> ratings;

    public Mreview() {
        this.title = "";
        ratings = new ArrayList<>();
    }

    public Mreview(String ttl) {
        this.title = ttl;
        ratings = new ArrayList<>();
    }

    public Mreview(String ttl, int firstRating) {
        this.title = ttl;
        this.ratings = new ArrayList<>();
        this.ratings.add(firstRating);
    }

    public void addRating(int r) {
        this.ratings.add(r);
    }

    public double aveRating() {
        int ratingSum = 0;
        for (int rating: this.ratings) {
            ratingSum += rating;
        }
        return (double) ratingSum / (double) this.ratings.size();
    }

    public int numRatings() {
        return this.ratings.size();
    }

    @Override
    public boolean equals(Object o) {
        return this.title.equals(((Mreview) o).title);
    }

    @Override
    public int compareTo(Mreview o) {
        return this.title.compareTo(o.title);
    }

    @Override
    public String toString() {
        String result = "";
        result += this.title + ", average " + aveRating() + " out of " + numRatings() + " ratings";
        return result;
    }
}
