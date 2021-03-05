//package com.gevbagratunyan.school.controllers;
//
//import com.gevbagratunyan.school.entity.models.Employee;
//import com.gevbagratunyan.school.entity.models.Pupil;
//import com.gevbagratunyan.school.service.services.EmployeeService;
//import com.gevbagratunyan.school.service.services.PupilService;
//import com.gevbagratunyan.school.service.services.UserService;
//import com.gevbagratunyan.school.transfer.employee.EmployeeResponse;
//import com.gevbagratunyan.school.transfer.pupil.PupilResponse;
//import com.gevbagratunyan.school.transfer.user.request.UserAddRequest;
//import com.gevbagratunyan.school.transfer.user.request.UserLoginRequest;
//import com.gevbagratunyan.school.transfer.user.request.UserUpdateRequest;
//import com.gevbagratunyan.school.transfer.user.response.UserResponse;
//import org.springframework.beans.BeanUtils;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import javax.validation.Valid;
//import java.util.List;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/users")
//public class UserController {
//
//    private final UserService userService;
//    private final EmployeeService employeeService;
//    private final PupilService pupilService;
//
//    public UserController(UserService userService, EmployeeService employeeService, PupilService pupilService) {
//        this.userService = userService;
//        this.employeeService = employeeService;
//        this.pupilService = pupilService;
//    }
//
//    @PutMapping("/login")
//    public ResponseEntity<Void> login(@RequestBody UserLoginRequest loginRequest){
//        userService.getByEmailAndPassword(loginRequest.getEMail(), loginRequest.getPassword());
//        return ResponseEntity.ok().build();
//    }
//
//    //done
//    @GetMapping
//    public String homePage(){
//        return "Hi! You are on the HomePage";
//    }
//
//    //done
//    @GetMapping("/{id}")
//    public UserResponse getUser(@PathVariable Long id){
//        return userService.get(id);
//    }
//
//    //done
//    @GetMapping("/employee/{id}")
//    public EmployeeResponse getEmployee(@PathVariable Long id){
//        EmployeeResponse response = new EmployeeResponse();
//        Employee employee = employeeService.getEmployeeById(id);
//        BeanUtils.copyProperties(employee,response);
//        return response;
//    }
//    //done
//    @GetMapping("/employees")
//    public List<Employee> getAllEmployees(){
//        return employeeService.getAllEmployees();
//    }
//
//    //done
//    @PostMapping
//    public UserResponse addUser(@Valid @RequestBody UserAddRequest userAddRequest) {
//        return userService.add(userAddRequest);
//    }
//
//    //done
//    @PutMapping("/update/{id}")
//    public UserResponse updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequest updateRequest){
//        return userService.update(id, updateRequest);
//    }
//
//    //done
//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
//        userService.delete(id);
//        return ResponseEntity.ok().build();
//    }
//
//    //done
//    @GetMapping("/pupil/{id}")
//    public PupilResponse getPupil(@PathVariable Long id){
//        PupilResponse response = new PupilResponse();
//        Pupil pupil = pupilService.getPupilById(id);
//        BeanUtils.copyProperties(pupil, response);
//        return response;
//    }
//
//    // ?? How to view HashMap on response ??
//    @GetMapping("/pupil/marks/{id}")
//    public Map<String, Byte> getYearMarks(@PathVariable Long id){
//        return pupilService.getPupilYearMarks(id);
//    }
//}
//
////Below presented the second method to add user, using Thymeleaf template. html files are already exists in views/user directory
////
////    @GetMapping("/new_user")
////    public String newUser(Model model) {
////        model.addAttribute("user", new User());
////        //returning directory and name of thymeleaf template
////        return "user/Create_New_User";
////    }
////
////    @PostMapping
////    public String addUser(@ModelAttribute("user") User user){
////        UserRequest userRequest= new UserRequest();
////        BeanUtils.copyProperties(user,userRequest);
////        userService.add(userRequest);
////        return "redirect:/users";
////    }
