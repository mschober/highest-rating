package com.porch.interview;

import java.util.LinkedList;
import java.util.Queue;

/**
* Created by mschober on 9/8/14.
*/
class LimitedRunningAverage {

    private final int limit;
    private final Queue<Integer> ratingsQue;
    private int num_reviews;
    private double avg;

    public LimitedRunningAverage(int newRating) {
        this(newRating, 100);
    }

    public LimitedRunningAverage(int newRating, int LIMIT) {
        this.num_reviews = 1;
        this.avg = newRating * 1.0;
        this.limit = LIMIT;
        this.ratingsQue = new LinkedList<Integer>();
        this.ratingsQue.add(newRating);
    }

    private LimitedRunningAverage updateAverage(int rating){
        this.ratingsQue.add(rating);
        this.avg = ((this.avg * this.num_reviews) + rating) / (this.num_reviews + 1);
        this.num_reviews++;
        return this;
    }

    private void deprecateAverage() {
        Integer oldestRating = this.ratingsQue.remove();
        this.avg = ((this.avg * this.num_reviews) - oldestRating) / (this.num_reviews - 1);
        this.num_reviews--;
    }

    public LimitedRunningAverage update(int newRating) {
        if(this.num_reviews < this.limit){ //num_reviews updates after update function
            return updateAverage(newRating);
        } else {
            deprecateAverage();
            return updateAverage(newRating);
        }
    }

    public double average() {
        return this.avg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LimitedRunningAverage average = (LimitedRunningAverage) o;

        if (Double.compare(average.avg, avg) != 0) return false;
        if (num_reviews != average.num_reviews) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = num_reviews;
        temp = Double.doubleToLongBits(avg);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Average{" +
                "num_reviews=" + num_reviews +
                ", avg=" + avg +
                '}';
    }

    public int num_reviews() {
        return this.num_reviews;
    }
}
