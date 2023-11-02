package InMemoryRepository;
import Domain.RepairService;
import Domain.ReviewAndRating;
import java.util.ArrayList;
import java.util.Objects;

public class ReviewAndRatingRepository implements InMemoryRepository<ReviewAndRating> {
    private final ArrayList<ReviewAndRating> reviewAndRatings = new ArrayList<ReviewAndRating>();

    @Override
    public void addItem(ReviewAndRating newReview) {
        reviewAndRatings.add(newReview);
    }

    @Override
    public void deleteItem(ReviewAndRating reviewToBeDeleted) {
        reviewAndRatings.remove(reviewToBeDeleted);
    }

    @Override
    public void updateItem(ReviewAndRating oldReview, ReviewAndRating newReview) {
        int index = reviewAndRatings.indexOf(oldReview);
        if (index != -1) {
            reviewAndRatings.set(index,newReview);
        }
    }

    @Override
    public ArrayList<ReviewAndRating> getAllItems() {
        return reviewAndRatings;
    }
}
