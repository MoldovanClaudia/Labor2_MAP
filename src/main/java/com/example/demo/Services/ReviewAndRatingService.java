//package com.example.demo.Services;
//
//import com.example.demo.Domain.ReviewAndRating;
//import com.example.demo.RepositorySpring.ReviewAndRatingRepositorySpring;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//public class ReviewAndRatingService {
//
//    private final ReviewAndRatingRepositorySpring reviewAndRatingRepo;
//
//    @Autowired
//    public ReviewAndRatingService(ReviewAndRatingRepositorySpring reviewAndRatingRepo) {
//        this.reviewAndRatingRepo = reviewAndRatingRepo;
//    }
//
//    public ReviewAndRating createReviewAndRating(ReviewAndRating reviewAndRating) {
//        return reviewAndRatingRepo.save(reviewAndRating);
//    }
//
//    public Iterable<ReviewAndRating> getAllReviewAndRatings() {
//        return reviewAndRatingRepo.findAll();
//    }
//
//    public Optional<ReviewAndRating> getReviewAndRating(Long reviewAndRatingId ) {
//        return reviewAndRatingRepo.findById(reviewAndRatingId);
//    }
//
//    public ReviewAndRating updateReviewAndRating(ReviewAndRating updatedReviewAndRating) {
//        return reviewAndRatingRepo.findById(updatedReviewAndRating.getReview_id())
//                .map(existingReviewAndRating -> {
//                    existingReviewAndRating.setCustomer(updatedReviewAndRating.getCustomer());
//                    existingReviewAndRating.setProduct(updatedReviewAndRating.getProduct());
//                    existingReviewAndRating.setRating(updatedReviewAndRating.getRating());
//                    return reviewAndRatingRepo.save(existingReviewAndRating);
//                })
//                .orElse(null);
//    }
//
//
//    public String deleteReviewAndRating(Long id) {
//        return reviewAndRatingRepo.findById(id)
//                .map(reviewAndRating -> {
//                    reviewAndRatingRepo.deleteById(id);
//                    return "ReviewAndRating deleted successfully!";
//                }).orElse("ReviewAndRating not found!");
//    }
//
//}
