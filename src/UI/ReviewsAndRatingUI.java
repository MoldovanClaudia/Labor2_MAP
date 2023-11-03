package UI;

import Controller.ReviewAndRatingController;
import Domain.ReviewAndRating;


import java.util.Scanner;
import java.util.ArrayList;

public class ReviewsAndRatingUI {
    public void ReviewAndRatingCase(ReviewAndRatingController reviewAndRatingController) {
        Scanner scanner = new Scanner(System.in);


        System.out.println("1. Add Review and Rating");
        System.out.println("2. Delete Review and Rating");
        System.out.println("3. Update Review and Rating");
        System.out.println("4. Get All Review and Ratings");

        int choice1 = scanner.nextInt();

        switch (choice1) {
            case 1:
                System.out.print("Enter review ID: ");
                int reviewId = scanner.nextInt();
                System.out.print("Enter product ID: ");
                int productId = scanner.nextInt();
                System.out.print("Enter customer ID: ");
                int customerId = scanner.nextInt();
                System.out.print("Enter rating: ");
                int rating = scanner.nextInt();

                reviewAndRatingController.addReviewAndRating(reviewId, productId, customerId, rating);

                System.out.println("Review and Rating added successfully.");
                break;
            case 2:
                System.out.print("Enter review ID to delete: ");
                System.out.print("Enter review ID: ");
                int reviewId2 = scanner.nextInt();
                System.out.print("Enter product ID: ");
                int productId2 = scanner.nextInt();
                System.out.print("Enter customer ID: ");
                int customerId2 = scanner.nextInt();
                System.out.print("Enter rating: ");
                int rating2 = scanner.nextInt();

                ReviewAndRating reviewAndRating = new ReviewAndRating(reviewId2, productId2, customerId2, rating2);
                reviewAndRatingController.deleteReviewAndRating(reviewAndRating);

                System.out.println("Review and Rating deleted successfully.");
                break;
            case 3:
                // Implement functionality for updating
                break;
            case 4:
                ArrayList<ReviewAndRating> reviewAndRatings = reviewAndRatingController.getAllReviewAndRatings();

                if (reviewAndRatings.isEmpty()) {
                    System.out.println("No Review and Ratings found.");
                } else {
                    System.out.println("List of Review and Ratings:");
                    for (ReviewAndRating reviewAndRatingIn : reviewAndRatings) {
                        System.out.println(reviewAndRatingIn);
                    }
                }
                break;
        }
    }
}
