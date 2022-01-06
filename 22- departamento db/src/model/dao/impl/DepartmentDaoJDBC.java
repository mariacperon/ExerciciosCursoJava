package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {

    private Connection con;

    public DepartmentDaoJDBC(Connection con) {
        this.con = con;
    }

    @Override
    public void insert(Department obj) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("insert into department (name) values (?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, "name");

            int rowsAffected = ps.executeUpdate();

            if(rowsAffected > 0){
                ResultSet rs = ps.getGeneratedKeys();
                if(rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            }
            else {
                throw new DbException("Unexpected error! No rows affected!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("update department set name=? where id=?");
            ps.setString(1, obj.getName());
            ps.setInt(2, obj.getId());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public void deleteById(Integer id) {
        PreparedStatement ps = null;
        try {
            ps = con.prepareStatement("delete from department where id=?");
            ps.setInt(1, Integer.parseInt("id"));

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closeStatement(ps);
        }
    }

    @Override
    public Department findById(Integer id) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Department dep = null;

        try {
            ps = con.prepareStatement("select * from department where id=?");
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if(rs.next()){
                dep = instantiateDepartment(rs);
                return dep;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
        return dep;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        dep.setId(rs.getInt("Id"));
        dep.setName(rs.getString("Name"));
        return dep;
    }

    @Override
    public List<Department> findAll() {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Department> departments = new ArrayList<>();
        Department dep = null;

        try {
            ps = con.prepareStatement("select * from department");

            rs = ps.executeQuery();
            while(rs.next()){
                dep = instantiateDepartment(rs);
                departments.add(dep);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DB.closeStatement(ps);
            DB.closeResultSet(rs);
        }
        return departments;
    }
}
