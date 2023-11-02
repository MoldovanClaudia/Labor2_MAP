package Domain;

public class ReviewAndRating {
    private int reviewId;
    private int productId;
    private int customerId;
    private int rating;

    public ReviewAndRating(int reviewId, int productId, int customerId, int rating) {
        this.reviewId = reviewId;
        this.productId = productId;
        this.customerId = customerId;
        this.rating = rating;
    }

    public int getReviewId() {
        return reviewId;
    }

    public int getProductId() {
        return productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getRating() {
        return rating;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Review And  Rating{" +
                "review id=" + reviewId +
                "product id=" + productId +
                "customer id=" + customerId +
                ", rating=" + rating +
                "}";
    }
}
