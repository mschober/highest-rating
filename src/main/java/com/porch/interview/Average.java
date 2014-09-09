package com.porch.interview;

/**
* Created by mschober on 9/8/14.
*/
class Average {

    private int num_reviews;
    private double avg;

    public Average(int newRating) {
        this.num_reviews = 1;
        this.avg = newRating * 1.0;
    }

    public Average update(int newRating) {
        this.avg = ((this.avg * this.num_reviews) + newRating) / (this.num_reviews + 1);
        this.num_reviews++;
        return this;
    }

    public double average() {
        return this.avg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Average average = (Average) o;

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
}
