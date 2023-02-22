package com.example.controller;

import com.example.mapper.EmployeeMapper;
import com.example.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

   @Autowired
   private EmployeeMapper employeeMapper;

   @GetMapping("/queryEmployeeList")
    public List<Employee> queryEmployeeList(){
       List<Employee> employeeList = employeeMapper.queryEmployeeList();

       for (Employee employee : employeeList)
           System.out.println(employee);

       return employeeList;
   }

//    @RequestMapping("/emps")
//    public String list(Model model) {
//        Collection<Employee> employees = employeeDao.getAll();
//        model.addAttribute("emps",employees);
//        return "emp/list";
//    }
//
//    @GetMapping("/emp")
//    public String toAddPage(Model model) {
//        //查出所有部门的信息
//        Collection<Department> department = departmentDao.getDepartment();
//        model.addAttribute("departments",department);
//        return "emp/add";
//    }
//
//    @PostMapping("/emp")
//    public String addEmp(Employee employee) {
//        employeeDao.save(employee);//调用底层业务方法保存员工信息
//        return "redirect:/emps";
//    }
//
//    // 去到员工的修改页面
//    @GetMapping("/emp/{id}")
//    public String toUpdateEmp(@PathVariable("id") Integer id, Model model) {
//        //查出原来的数据
//        Employee employee = employeeDao.getEmployeeById(id);
//        model.addAttribute("emp",employee);
//        //查出所有部门的信息
//        Collection<Department> department = departmentDao.getDepartment();
//        model.addAttribute("departments",department);
//        return "emp/update";
//    }
//
//    @PostMapping("/updateEmp")
//    public String updateEmp(Employee employee) {
//        employeeDao.save(employee);
//        return "redirect:/emps";
//    }
//
//    // 删除员工
//    @GetMapping("/delemp/{id}")
//    public String deleteEmp(@PathVariable("id") Integer id) {
//        employeeDao.delete(id);
//        return "redirect:/emps";
//    }
}
