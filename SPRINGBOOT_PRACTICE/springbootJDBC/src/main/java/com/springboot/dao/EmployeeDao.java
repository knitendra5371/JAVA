package com.springboot.dao;

import com.springboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

   /* public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
*/

    static class EmployeeRowMapper implements RowMapper< Employee > {

        @Override
        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new Employee();
            employee.setId(rs.getInt("id"));
            employee.setName(rs.getString("name"));
            employee.setSalary(rs.getInt("salary"));
            return employee;
        }
    }


    public int saveEmployee(Employee e){
//        String query="insert into employee values( "+e.getId()+",'"+ e.getName()+"',"+e.getSalary()+")";
        String query="insert into employee values(?,?,?)"; // this is a good way , above way is not professional to create query
        System.out.println("query=> "+query);
        return jdbcTemplate.update(query, e.getId(),e.getName(),e.getSalary());
    }
    public int updateEmployee(Employee e){
//        String query="update employee set name ='"+e.getName()+"',salary="+e.getSalary()+" where id="+e.getId();
        String query="update employee set name =?,salary=? where id=?";
        return jdbcTemplate.update(query,e.getName(),e.getSalary(),e.getId());
    }
    public int deleteEmployee(Employee e){
        String query="delete from employee where id="+e.getId();
        return jdbcTemplate.update(query);
    }

    public List< Employee > findAll() {
        return jdbcTemplate.query("select * from employee",
//                new EmployeeRowMapper(), // We should use this way when Entity field name and table column name are different
                BeanPropertyRowMapper.newInstance(Employee.class)
        );
    }

    public Optional < Employee > findById(int id) {
        return Optional.ofNullable(jdbcTemplate.queryForObject("select * from employee where id=?",
//                new BeanPropertyRowMapper<Employee>(Employee.class) // it will work also
                BeanPropertyRowMapper.newInstance(Employee.class)
                ,id));
    }
}
