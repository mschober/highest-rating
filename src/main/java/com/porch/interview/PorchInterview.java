package com.porch.interview;

/*
Problem: Given a list of reviews on Porch.com, return the proKey for the pro with the highest average rating. You should only take into account the last 100 reviews for a specific pro when calculating the pro's rating.

You may use any standard libraries.
Please state any assumptions.

You will be evaluated based on code clarity, code quality, and efficiency.
*/

import java.util.Date;
import java.util.List;

public class PorchInterview {
    private class Review {
        // unique identifier for the review
        int reviewId;

        // rating (1-5 stars)
        int rating;

        // text of the review
        String reviewText;

        // unique identifier for the pro being reviewed
        int proKey;

        // unique identifier for the reviewer
        int reviewerKey;

        // date of the review
        Date reviewDate;

        public int getReviewId() {
            return reviewId;
        }

        public int getRating() {
            return rating;
        }

        public String getReviewText() {
            return reviewText;
        }

        public int getProKey() {
            return proKey;
        }

        public int getReviewerKey() {
            return reviewerKey;
        }

        public Date getReviewDate() {
            return reviewDate;
        }
    }

    // implement this function
    public static int getHighestRatedPro(List<Review> reviews) {
        return 0;
    }
}