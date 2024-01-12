//package com.example.demo.ControllerSpring;
//
//import com.example.demo.Domain.ReviewAndRating;
//import com.example.demo.Services.ReviewAndRatingService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/api/reviewss")
//
//public class ReviewAndRatingControllerSpring {
//
//    private final ReviewAndRatingService reviewAndRatingService;
//
//    @Autowired
//    public ReviewAndRatingControllerSpring(ReviewAndRatingService reviewAndRatingService) {
//        this.reviewAndRatingService = reviewAndRatingService;
//    }
//
//    @GetMapping
//    public ResponseEntity<Iterable<ReviewAndRating>> getAllReviewAndRatings() {
//        return ResponseEntity.ok(reviewAndRatingService.getAllReviewAndRatings());
//    }
//
//    @PostMapping
//    public ResponseEntity<ReviewAndRating> createReviewAndRating(@RequestBody ReviewAndRating reviewAndRating) {
//        return ResponseEntity.status(HttpStatus.CREATED).body(reviewAndRatingService.createReviewAndRating(reviewAndRating));
//    }
//
//    @GetMapping("/{id}")
//    public ResponseEntity<Optional<ReviewAndRating>> getReviewAndRating(@PathVariable Long id) {
//        Optional<ReviewAndRating> reviewAndRating = reviewAndRatingService.getReviewAndRating(id);
//
//        if (reviewAndRating.isEmpty())
//            return ResponseEntity.notFound().build();
//        return ResponseEntity.ok(reviewAndRating);
//    }
//
//    @PutMapping("/{id}")
//    public ResponseEntity<Optional<ReviewAndRating>> updateReviewAndRating(@PathVariable Long id,
//                                                             @RequestBody ReviewAndRating reviewAndRating) {
//        if (!reviewAndRating.getReview_id().equals(id))
//            return ResponseEntity.notFound().build();
//        Optional<ReviewAndRating> updated = Optional.ofNullable(reviewAndRatingService.updateReviewAndRating(reviewAndRating));
//        return ResponseEntity.ok(updated);
//
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> deleteReviewAndRating(@PathVariable Long id) {
//        return ResponseEntity.ok(reviewAndRatingService.deleteReviewAndRating(id));
//    }
//}
