package RepositoryDB;

import Domain.Job;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class JobRepositoryDB extends Database implements RepositoryInterface<Job> {

    @Override
    public void add(Job job) {
        String sql = "INSERT INTO job(jobId, jobName, jobDescription) VALUES(?, ?, ?);";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, String.valueOf(job.getJobId()));
            stmt.setString(2, job.getJobName());
            stmt.setString(3, job.getJobDescription());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Job deletedObject) {
        String sql = "DELETE FROM job WHERE jobId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, deletedObject.getJobId());
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Job oldObject, Job newObject) {
        String sql = "UPDATE job SET jobName=?, jobDecription=? WHERE jobId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setString(1, newObject.getJobName());
            stmt.setString(2, newObject.getJobDescription());
            stmt.setInt(3, oldObject.getJobId());

            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Job> readAll() {
        String sql = "SELECT * FROM job;";

        try {
            Statement stmt = conn().createStatement();
            List<Job> jobs = new ArrayList<>();
            ResultSet resultSet = stmt.executeQuery(sql);

            while (resultSet.next()) {
                Job job = new Job(
                        resultSet.getInt("jobId"),
                        resultSet.getString("jobName"),
                        resultSet.getString("jobDescription")
                );
                jobs.add(job);
            }
            return (ArrayList<Job>) jobs;
        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public Job findById(ArrayList<String> identifier) {
        String sql = "SELECT * FROM job WHERE jobId = ?;";

        try {
            PreparedStatement stmt = conn().prepareStatement(sql);
            stmt.setInt(1, Integer.parseInt(identifier.get(0)));
            ResultSet resultSet = stmt.executeQuery();

            if (resultSet.next()) {
                return new Job(
                        resultSet.getInt("jobId"),
                        resultSet.getString("jobName"),
                        resultSet.getString("jobDescription")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

}

