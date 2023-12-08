package UiDB;

import ControllerDB.ReviewAndRatingControllerDB;
import Domain.ReviewAndRating;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;

public class ReviewsAndRatingUiDB {
    private static ReviewsAndRatingUiDB instance;

    private ReviewsAndRatingUiDB() {
    }

    public static synchronized ReviewsAndRatingUiDB getInstance() {
        if (instance == null) {
            instance = new ReviewsAndRatingUiDB();
        }
        return instance;
    }
    public void ReviewAndRatingCase(ReviewAndRatingControllerDB reviewAndRatingController) {
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
                int reviewId2 = scanner.nextInt();

                ArrayList<String> reviewIdsToDelete = new ArrayList<>();
                reviewIdsToDelete.add(String.valueOf(reviewId2));

                reviewAndRatingController.deleteReviewAndRating(reviewIdsToDelete);
                System.out.println("Review and Rating deleted successfully.");
                break;
            case 3:
                System.out.print("Enter review ID to update: ");
                int reviewIdToUpdate = scanner.nextInt();

                ArrayList<String> reviewIdsToUpdate = new ArrayList<>();
                reviewIdsToUpdate.add(String.valueOf(reviewIdToUpdate));

                Map<String, String> review_updates = new HashMap<>();

                System.out.print("Enter new product ID (press Enter to skip): ");
                String newProductID = scanner.nextLine().trim();
                if (!newProductID.isEmpty()) {
                    review_updates.put("productID", newProductID);
                }

                System.out.print("Enter new customer ID (press Enter to skip): ");
                String newCustomerID = scanner.nextLine().trim();
                if (!newCustomerID.isEmpty()) {
                    review_updates.put("customerID", newCustomerID);
                }

                reviewAndRatingController.updateReviewAndRating(reviewIdsToUpdate, review_updates);
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
