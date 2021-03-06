package com.gevbagratunyan.school.controllers;

import com.gevbagratunyan.school.entity.models.Admin;
import com.gevbagratunyan.school.entity.models.Employee;
import com.gevbagratunyan.school.entity.models.Pupil;
import com.gevbagratunyan.school.entity.models.User;
import com.gevbagratunyan.school.service.services.AdminService;
import com.gevbagratunyan.school.service.services.EmployeeService;
import com.gevbagratunyan.school.service.services.PupilService;
import com.gevbagratunyan.school.service.services.UserService;
import com.gevbagratunyan.school.transfer.admin.request.*;
import com.gevbagratunyan.school.transfer.admin.response.AdminResponse;
import com.gevbagratunyan.school.transfer.employee.EmployeeResponse;
import com.gevbagratunyan.school.transfer.pupil.PupilResponse;
import com.gevbagratunyan.school.transfer.user.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@Validated
@RequestMapping("/admins")
public class AdminController {

	private final UserService userService;
	private final EmployeeService employeeService;
	private final PupilService pupilService;
	private final AdminService adminService;

	public AdminController(UserService userService, EmployeeService employeeService, PupilService pupilService, AdminService adminService) {
		this.userService = userService;
		this.employeeService = employeeService;
		this.pupilService = pupilService;
		this.adminService = adminService;
	}

    //DONE
    @GetMapping
    public String homePage() {
        return "Hi! You are on the Admins Page";
    }

                    //*************************ADMIN********************//

	//DONE
	@PutMapping("/login")
	public ResponseEntity<Void> login( @Valid @RequestBody AdminLoginRequest loginRequest) {
	    try{
            AdminResponse response = adminService.getByUsernameAndPassword(loginRequest.getMail(), loginRequest.getPassword());
            adminService.setLoggedIn(response.getId(), true);
        } catch(NoSuchElementException e){
	        return  ResponseEntity.notFound().build();
        }
		return ResponseEntity.ok().build();
	}

	//DONE
	@PutMapping("/logout/{id}")
	public ResponseEntity<Void> logout(@PathVariable Long id) {
		adminService.setLoggedIn(id, false);
		return ResponseEntity.ok().build();
	}

	//DONE
	@GetMapping("/{id}")
	public AdminResponse getAdmin(@PathVariable Long id) {
		return adminService.get(id);
	}


	//??
	@PostMapping("/create")
	public AdminResponse addAdmin(@Valid @RequestBody AdminAddRequest adminAddRequest) {
		return adminService.add(adminAddRequest);
	}

	//DONE
	@GetMapping("/all")
	public List<Admin> getAllAdmins(){
		return adminService.getAllAdmins();
	}

	//DONE
	@PutMapping("/update/{id}")
	public AdminResponse updateAdmin(@PathVariable Long id, @Valid @RequestBody AdminUpdateRequest updateRequest) {
		return adminService.update(id, updateRequest);
	}

	//DONE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
		adminService.delete(id);
		return ResponseEntity.ok().build();
	}

		//*************************PUPIL********************//

	//DONE
	@GetMapping("/pupils/{id}")
	public PupilResponse getPupil(@PathVariable Long id) {
		return pupilService.get(id);
	}

	//DONE
	@PostMapping("pupils/create")
	public ResponseEntity<Void> createPupil(@Valid @RequestBody AdminPupilCreateRequest pupilCreateRequest) {
		pupilService.add(pupilCreateRequest);
		return ResponseEntity.ok().build();
	}

	//DONE
	@PutMapping("pupils/set-mark/{id}")
	public ResponseEntity<Void> setMark(@PathVariable Long id, @Valid @RequestBody AdminPupilSetMarkRequest setMarkRequest) {
		pupilService.setYearMark(id,setMarkRequest);
		return ResponseEntity.ok().build();
	}

	//DONE
	@DeleteMapping("pupils/delete/{id}")
	public ResponseEntity<Void> deletePupil(@PathVariable Long id){
		pupilService.delete(id);
		return ResponseEntity.ok().build();
	}

	//DONE
	@GetMapping("/pupils/all")
	public List<Pupil> getAllPupils(){
		return pupilService.getAllPupils();
	}

	//DONE
	@PutMapping("/pupils/update/{id}")
	public PupilResponse updatePupil(@PathVariable Long id, @Valid @RequestBody AdminPupilUpdateRequest updateRequest){
		return pupilService.update(id, updateRequest);
	}


	//*************************USER********************//


	//DONE
	@GetMapping("/users/{id}")
	public UserResponse getUser(@PathVariable Long id) {
		return userService.get(id);
	}

	//DONE
	@GetMapping("/users/all")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User>  users = userService.getAllUsers();
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	//DONE
	@DeleteMapping("/users/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.ok().build();
	}


	           //*************************EMPLOYEE********************//

	//DONE
	@GetMapping("/employees/{id}")
	public EmployeeResponse getEmployee(@PathVariable Long id) {
		return employeeService.get(id);
	}


	@GetMapping("/employees/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		return new ResponseEntity<>(employees, HttpStatus.OK);

//		return ResponseEntity.ok(employees);
	}

	//DONE
	@PostMapping("/employees/create")
	public EmployeeResponse createEmployee(@Valid @RequestBody AdminEmployeeCreateRequest employeeCreateRequest) {
		return employeeService.add(employeeCreateRequest);
	}

	//DONE
	@DeleteMapping("/employees/delete/{id}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
		employeeService.delete(id);
		return ResponseEntity.ok().build();
	}

	//DONE
	@PutMapping("employees/update/{id}")
	public EmployeeResponse updateEmployee(@PathVariable Long id, @Valid @RequestBody AdminEmployeeUpdateRequest updateRequest) {
		return employeeService.update(id,updateRequest);
	}

	@PutMapping("/employees/banking/{id}")
	public EmployeeResponse updateBanking(@PathVariable Long id, @Valid @RequestBody AdminEmployeeBankingUpdateRequest bankingUpdateRequest) {
		return employeeService.updateBanking(id, bankingUpdateRequest);
	}

}
