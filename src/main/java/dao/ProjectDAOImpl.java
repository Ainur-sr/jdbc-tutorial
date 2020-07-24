package dao;

import config.UtilDB;
import entity.Project;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProjectDAOImpl implements ProjectDAO {
    @Override
    public void add(Project project) {
        String sqlQuery = "INSERT INTO PROJECT (ID, TITLE) VALUES(?, ?)";

        try (PreparedStatement preparedStatement = UtilDB.getConnection().prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1, project.getId());
            preparedStatement.setString(2, project.getTitle());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Project> getAll() {
        List<Project> projectList = new ArrayList<>();
        String sqlQuery = "SELECT ID, TITLE FROM PROJECT";

        try (Statement statement = UtilDB.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                Project project = new Project();
                project.setId(resultSet.getLong("ID"));
                project.setTitle(resultSet.getString("TITLE"));

                projectList.add(project);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return projectList;
    }

    @Override
    public Project getById(Long id) {
        String sqlQuery = "SELECT ID, TITLE FROM PROJECT WHERE ID=?";
        Project project = null;

        try (PreparedStatement preparedStatement = UtilDB.getConnection().prepareStatement(sqlQuery)) {
            project = new Project();
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();

            project.setId(resultSet.getLong("ID"));
            project.setTitle(resultSet.getString("TITLE"));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return project;
    }

    @Override
    public void update(Project project) {
        String sqlQuery = "UPDATE PROJECT SET TITLE=? WHERE ID=?";
        try (PreparedStatement preparedStatement = UtilDB.getConnection().prepareStatement(sqlQuery)) {
            preparedStatement.setString(1, project.getTitle());
            preparedStatement.setLong(2, project.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void remove(Project project) {
        String sqlQuery = "DELETE FROM PROJECT WHERE ID=?";
        try (PreparedStatement preparedStatement = UtilDB.getConnection().prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1, project.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
