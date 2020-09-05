package testboot;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import testboot.model.ERole;
import testboot.model.Employee;
import testboot.model.Role;
import testboot.model.User;
import testboot.repository.RoleRepository;
import testboot.repository.UserRepository;


//@CrossOrigin(origins = "https://gentle-scrubland-86626.herokuapp.com")
@CrossOrigin
@RestController
public class TestController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
    public List<Employee> firstPage() {
        User user = new User("use1",
                "test@test.com",
                "123233");


        Set<Role> roles = new HashSet<>();
        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
        roles.add(adminRole);

        user.setRoles(roles);

        userRepository.save(user);

        List<Employee> tempEmployees = new ArrayList<>();
        Employee emp1 = new Employee();
        emp1.setName("emp1");
        emp1.setDesignation("manager");
        emp1.setEmpId("1");
        emp1.setSalary(3000);
        Employee emp2 = new Employee();
        emp2.setName("emp2");
        emp2.setDesignation("developer");
        emp2.setEmpId("2");
        emp2.setSalary(3000);
        tempEmployees.add(emp1);
        tempEmployees.add(emp2);
        return tempEmployees;
    }





}
