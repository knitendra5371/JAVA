package com.springboot.dao;

import com.springboot.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

   /* public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
*/
    public int saveEmployee(Employee e){
        String query="insert into employee values( "+e.getId()+",'"+ e.getName()+"',"+e.getSalary()+")";
        System.out.println("query=> "+query);
        return jdbcTemplate.update(query);
    }
    public int updateEmployee(Employee e){
        String query="update employee set name ='"+e.getName()+"',salary="+e.getSalary()+" where id="+e.getId();
        return jdbcTemplate.update(query);
    }
    public int deleteEmployee(Employee e){
        String query="delete from employee where id="+e.getId();
        return jdbcTemplate.update(query);
    }
}
