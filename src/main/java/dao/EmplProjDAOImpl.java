package dao;

import config.UtilDB;
import entity.EmplProj;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmplProjDAOImpl implements EmplProjDAO {
    @Override
    public void add(EmplProj emplProj) {
        String sqlQuery = "INSERT INTO EMPL_PROJ (EMPLOYEE_ID, PROJECT_ID) VALUES(?, ?)";

        try (PreparedStatement preparedStatement = UtilDB.getConnection().prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<EmplProj> getAll() {
        List<EmplProj> emplProjList = new ArrayList<>();
        String sqlQuery = "SELECT EMPLOYEE_ID, PROJECT_ID FROM EMPL_PROJ";

        try (Statement statement = UtilDB.getConnection().createStatement()) {
            ResultSet resultSet = statement.executeQuery(sqlQuery);

            while (resultSet.next()) {
                EmplProj emplProj = new EmplProj();
                emplProj.setEmployeeId(resultSet.getLong("EMPLOYEE_ID"));
                emplProj.setProjectId(resultSet.getLong("PROJECT_ID"));

                emplProjList.add(emplProj);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return emplProjList;
    }

    @Override
    public EmplProj getByEmployeeIdAndProjectId(Long employeeId, Long projectId) {
        String sqlQuery = "SELECT EMPLOYEE_ID, PROJECT_ID FROM EMPL_PROJ WHERE EMPLOYEE_ID=? AND PROJECT_ID=?";
        EmplProj emplProj = null;

        try (PreparedStatement preparedStatement = UtilDB.getConnection().prepareStatement(sqlQuery)) {
            emplProj = new EmplProj();

            preparedStatement.setLong(1, employeeId);
            preparedStatement.setLong(2, projectId);

            ResultSet resultSet = preparedStatement.executeQuery();

            emplProj.setEmployeeId(resultSet.getLong("EMPLOYEE_ID"));
            emplProj.setProjectId(resultSet.getLong("PROJECT_ID"));

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return emplProj;
    }

    @Override
    public void update(EmplProj emplProj) {
        String sqlQuery = "UPDATE EMPL_PROJ SET EMPLOYEE_ID=?, PROJECT_ID=?";
        try (PreparedStatement preparedStatement = UtilDB.getConnection().prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());

            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void remove(EmplProj emplProj) {
        String sqlQuery = "DELETE FROM EMPL_PROJ WHERE EMPLOYEE_ID=? AND PROJECT_ID=?";

        try (PreparedStatement preparedStatement = UtilDB.getConnection().prepareStatement(sqlQuery)) {
            preparedStatement.setLong(1, emplProj.getEmployeeId());
            preparedStatement.setLong(2, emplProj.getProjectId());

            preparedStatement.execute();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
