package service;

import bl.Util;
import dao.EmplProjDAO;
import entity.EmplProj;

import java.sql.SQLException;
import java.util.List;

public class EmplProjService extends Util implements EmplProjDAO {

    @Override
    public void add(EmplProj emplProj) throws SQLException {

    }

    @Override
    public List<EmplProj> getAll() throws SQLException {
        return null;
    }

    @Override
    public EmplProj getByEmployeeIdAndProjectId(Long employeeId, Long projectId) throws SQLException {
        return null;
    }

    @Override
    public void update(EmplProj emplProj) throws SQLException {

    }

    @Override
    public void remove(EmplProj emplProj) throws SQLException {

    }
}
