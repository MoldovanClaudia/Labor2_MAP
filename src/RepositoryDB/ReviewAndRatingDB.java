package RepositoryDB;

import Domain.ReviewAndRating;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ReviewAndRatingRepositoryDB extends Database implements RepositoryInterface<ReviewAndRating> {

    @Override
    public void add(ReviewAndRating reviewAndRating) {
        String sql = "INSERT INTO reviewandrating(reviewId, productId, cutomerId, rating) VALUES(?, ?, ?, ?);";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, String.valueOf(reviewAndRating.getReviewId()));
            stmt.setString(2, String.valueOf(reviewAndRating.getProductId()));
            stmt.setString(3, String.valueOf(reviewAndRating.getCustomerId()));
            stmt.setInt(4, reviewAndRating.getRating());


            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(ReviewAndRating deletedObject) {
        String sql = "DELETE FROM reviewandrating WHERE reviewId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, deletedObject.getReviewId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(ReviewAndRating oldObject, ReviewAndRating newObject) {
        String sql = "UPDATE reviewandrating SET productId=?, customerId=?, rating=? WHERE reviewId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, newObject.getProductId());
            stmt.setInt(2, newObject.getCustomerId());
            stmt.setInt(3, newObject.getRating());
            stmt.setInt(4, oldObject.getReviewId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<ReviewAndRating> readAll() {
        String sql = "SELECT * FROM reviewandrating;";

        try {
            Statement stmt = conn().createStatement();
            List<ReviewAndRating> ratings = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                ReviewAndRating reviewAndRating = new ReviewAndRating(
                        resultSet.getInt("reviewId"),
                        resultSet.getInt("productId"),
                        resultSet.getInt("customerId"),
                        resultSet.getInt("rating")
                );
                ratings.add(reviewAndRating);
            }
            return (ArrayList<ReviewAndRating>) ratings;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public ReviewAndRating findById(ArrayList<String> identifier) {
        String sql = "SELECT * FROM reviewandrating WHERE reviewId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(identifier.get(0)));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new ReviewAndRating(
                        resultSet.getInt("reviewId"),
                        resultSet.getInt("productId"),
                        resultSet.getInt("customerId"),
                        resultSet.getInt("rating")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

