package ControllerDB;

import Domain.ReviewAndRating;
import RepositoryDB.ReviewAndRatingRepositoryDB;

import java.util.ArrayList;
import java.util.Map;

public class ReviewAndRatingController {
    private final ReviewAndRatingRepositoryDB reviewAndRatingRepository;

    public ReviewAndRatingController(ReviewAndRatingRepositoryDB reviewAndRatingRepository) {
        this.reviewAndRatingRepository = reviewAndRatingRepository;
    }

    public void addReviewAndRating(int reviewId, int productId, int customerId, int rating) {
        ReviewAndRating newReview = new ReviewAndRating(reviewId,productId,customerId,rating);
        reviewAndRatingRepository.add(newReview);
    }

    public void deleteReviewAndRating(ReviewAndRating reviewAndRating) {
        reviewAndRatingRepository.delete(reviewAndRating);
    }

    public void deleteReviewAndRating(ArrayList<String> reviewAndRatingId) {
        ReviewAndRating reviewAndRating = reviewAndRatingRepository.findById(reviewAndRatingId);
        reviewAndRatingRepository.delete(reviewAndRating);

    }

    public void updateReviewAndRating(ArrayList<String> reviewAndRatingId, Map<String, String> reviewAndRating_updates) {
        ReviewAndRating oldReviewAndRating = reviewAndRatingRepository.findById(reviewAndRatingId);

        if (oldReviewAndRating != null) {
            ReviewAndRating newReviewAndRating = new ReviewAndRating(
                    oldReviewAndRating.getReviewId(),
                    oldReviewAndRating.getProductId(),
                    oldReviewAndRating.getCustomerId(),
                    oldReviewAndRating.getRating()
            );


            reviewAndRatingRepository.update(oldReviewAndRating, newReviewAndRating);
            System.out.println("Review updated successfully.");
        } else {
            System.out.println("Review not found.");
        }
    }

    public ArrayList<ReviewAndRating> getAllReviewAndRatings() {
        return reviewAndRatingRepository.readAll();
    }
}

