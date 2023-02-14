package com.example.dao;

import com.example.pojo.Department;
import com.example.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

// 员工Dao
@Repository
public class EmployeeDao {
    // 模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;

    // 员工有所属的部门
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<>();
        employees.put(1001, new Employee(1001, "刘一", "1@com", 1, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "刘二", "2@com", 0, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "刘三", "3@com", 0, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "刘四", "4@com", 1, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "刘五", "5@com", 1, new Department(105, "后勤部")));
    }

    // 主键自增
    private static Integer initId = 1006;

    // 增加一个员工
    public void save(Employee employee) {
        if (employee.getId() == null)
            employee.setId(initId++);
        employee.setDepartment(departmentDao.getDepartmentByid(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    // 查询全部员工信息
    public Collection<Employee> getAll() {
        return employees.values();
    }

    // 通过id查询员工
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    // 通过id删除员工
    public Employee delete(Integer id) {
        return employees.remove(id);
    }
}
