package com.porch.interview;

/*
Problem: Given a list of reviews on Porch.com, return the proKey for the pro with the highest average rating. You should only take into account the last 100 reviews for a specific pro when calculating the pro's rating.

You may use any standard libraries.
Please state any assumptions.

You will be evaluated based on code clarity, code quality, and efficiency.
*/

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class PorchInterview {
    private final ArrayList<Review> reviews;

    public PorchInterview(List<String[]> reviews) throws IOException, ParseException {
        List<Review> reviewList = new ArrayList<Review>();
        for(String[] reviewLine: reviews) {
            reviewList.add(new Review(reviewLine));
        }
        this.reviews = new ArrayList<Review>(reviewList);
    }

    public List<Review> getReviews(){
        return new ArrayList<Review>(this.reviews);
    }

    public Review createReview(String[] reviewLine) throws ParseException {
        return new Review(reviewLine);
    }

    private static class ProKey {

        private final int proKey;

        public ProKey(Review r) {
            this.proKey = r.getProKey();
        }

        public int key() {
            return this.proKey;
        }

        @Override
        public String toString(){
            return String.valueOf(key());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ProKey proKey1 = (ProKey) o;

            if (proKey != proKey1.proKey) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return proKey;
        }
    }

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

        private Review(String[] review) throws ParseException {
            this(review[0], review[1], review[2], review[3], review[4], review[5]);
        }

        private Review(String reviewId, String rating, String reviewText, String proKey, String reviewerKey, String reviewDate) throws ParseException {
            this(
                    Integer.valueOf(reviewId),
                    Integer.valueOf(rating),
                    reviewText,
                    Integer.valueOf(proKey),
                    Integer.valueOf(reviewerKey),
                    reviewDate
            );

        }

        private Review(int reviewId, int rating, String reviewText, int proKey, int reviewerKey, String reviewDate) throws ParseException {
            this.reviewId = reviewId;
            this.rating = rating;
            this.reviewText = reviewText;
            this.proKey = proKey;
            this.reviewerKey = reviewerKey;
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            this.reviewDate = formatter.parse(reviewDate);
        }

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

    public static int countReviews(List<Review> reviews){
        return reviews.size();
    }

    // implement this function
    public static int getHighestRatedPro(List<Review> reviews) {
        HashMap<ProKey, LimitedRunningAverage> highestAverage = new HashMap<ProKey, LimitedRunningAverage>(); //prokey, average
        LimitedRunningAverage a = new LimitedRunningAverage(1);
        double currentAverage = 0;
        double winningAverage = 0;
        ProKey winningKey = null;
        for(Review r : reviews){
            ProKey pk = new ProKey(r);
            LimitedRunningAverage avg;
            if(highestAverage.containsKey(pk)){
                avg = highestAverage.get(pk);
                highestAverage.put(pk, avg.update(r.getRating()));
            } else {
                avg = new LimitedRunningAverage(r.getRating());
                highestAverage.put(pk, avg);
            }
            currentAverage = avg.average();
            winningAverage = winningKey != null? highestAverage.get(winningKey).average(): 0;
            if(currentAverage > winningAverage){
                winningAverage = currentAverage;
                winningKey = pk;
            }
//            System.out.println(highestAverage.entrySet());
        }
//        System.out.println(highestAverage.get(winningKey).num_reviews());
//        System.out.println(highestAverage.get(winningKey).average());

        return winningKey.key();
    }
}