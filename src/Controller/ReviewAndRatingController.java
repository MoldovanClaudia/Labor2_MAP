package Controller;

import Domain.Customer;
import Domain.ReviewAndRating;
import Domain.Shipment;
import InMemoryRepository.ReviewAndRatingRepository;

import java.util.ArrayList;
import java.util.Map;

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

    public void deleteReviewAndRating(int reviewAndRatingId) {
        ReviewAndRating reviewAndRating = reviewAndRatingRepository.findById(reviewAndRatingId);
        reviewAndRatingRepository.deleteItem(reviewAndRating);

    }

    public void updateReviewAndRating(int reviewAndRatingId, Map<String, String> reviewAndRating_updates) {
        ReviewAndRating oldReviewAndRating = reviewAndRatingRepository.findById(reviewAndRatingId);

        if (oldReviewAndRating != null) {
            ReviewAndRating newReviewAndRating = new ReviewAndRating(
                    oldReviewAndRating.getReviewId(),
                    oldReviewAndRating.getProductId(),
                    oldReviewAndRating.getCustomerId(),
                    oldReviewAndRating.getRating()
            );


            reviewAndRatingRepository.updateItem(oldReviewAndRating, newReviewAndRating);
            System.out.println("Review updated successfully.");
        } else {
            System.out.println("Review not found.");
        }
    }

    public ArrayList<ReviewAndRating> getAllReviewAndRatings() {
        return reviewAndRatingRepository.getAllItems();
    }
}

