package com.sample.DAO;
import com.sample.Models.Employee;
import java.util.List;
public interface EmployeeDAO {
	void Save(Employee emp);
	void Update(Employee emp);
	void Delete(int id);
	List<Employee> GetAll();

}
