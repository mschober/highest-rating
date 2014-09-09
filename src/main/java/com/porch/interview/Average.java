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
}
