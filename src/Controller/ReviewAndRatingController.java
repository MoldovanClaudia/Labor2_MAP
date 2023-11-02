package Controller;

import Domain.ReviewAndRating;
import InMemoryRepository.ReviewAndRatingRepository;

import java.util.ArrayList;

public class ReviewAndRatingController {
    private final ReviewAndRatingRepository reviewAndRatingRepository;

    public ReviewAndRatingController(ReviewAndRatingRepository reviewAndRatingRepository) {
        this.reviewAndRatingRepository = reviewAndRatingRepository;
    }

    public void addReviewAndRating(int reviewId, int productId, int customerId, int rating) {
        ReviewAndRating newReview = new ReviewAndRating(reviewId,productId,customerId,rating);
        reviewAndRatingRepository.addItem(newReview);
    }

    public void deleteReviewAndRating(ReviewAndRating reviewAndRating) {
        reviewAndRatingRepository.deleteItem(reviewAndRating);
    }

    public void updateReviewAndRating(ReviewAndRating oldReview, ReviewAndRating newReview) {
        reviewAndRatingRepository.updateItem(oldReview, newReview);
    }

    public ArrayList<ReviewAndRating> getAllReviewAndRatings() {
        return reviewAndRatingRepository.getAllItems();
    }
}

