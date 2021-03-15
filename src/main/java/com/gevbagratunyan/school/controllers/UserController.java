package com.gevbagratunyan.school.controllers;

import com.gevbagratunyan.school.entity.models.Employee;
import com.gevbagratunyan.school.entity.models.Pupil;
import com.gevbagratunyan.school.entity.models.User;
import com.gevbagratunyan.school.service.services.UserService;
import com.gevbagratunyan.school.service.services.EmployeeService;
import com.gevbagratunyan.school.service.services.PupilService;
import com.gevbagratunyan.school.transfer.user.request.*;
import com.gevbagratunyan.school.transfer.user.response.UserResponse;
import com.gevbagratunyan.school.transfer.employee.EmployeeResponse;
import com.gevbagratunyan.school.transfer.pupil.PupilResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;

@RestController
@Validated
@RequestMapping("/api")
public class UserController {

	private final UserService userService;
	private final EmployeeService employeeService;
	private final PupilService pupilService;

	public UserController(UserService userService, EmployeeService employeeService, PupilService pupilService, UserService adminService) {
		this.userService = userService;
		this.employeeService = employeeService;
		this.pupilService = pupilService;
	}

    //DONE
    @GetMapping
    public String homePage() {
        return "Hi! You are on the Api Page";
    }

                    //*************************USER********************//


	//DONE
	@GetMapping("/admins/{id}")
	public UserResponse getAdmin(@PathVariable Long id) {
		return userService.get(id);
	}

	//??
	@PostMapping("/admins/create")
	public UserResponse addAdmin(@Valid @RequestBody UserAddRequest userAddRequest) {
		return userService.add(userAddRequest);
	}

	@PutMapping("/admins/update/{id}")
	public UserResponse updateAdmin(@PathVariable Long id, @Valid @RequestBody UserUpdateRequest updateRequest) {
		return userService.update(id, updateRequest);
	}

	//DONE
	@DeleteMapping("/admins/delete/{id}")
	public ResponseEntity<Void> deleteAdmin(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.ok().build();
	}

	@DeleteMapping("/users/delete/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
		userService.delete(id);
		return ResponseEntity.ok().build();
	}

	//DONE
	@PutMapping("/users/update/{id}")
	public UserResponse updateUser(@PathVariable Long id, @Valid @RequestBody UserUpdateRequest updateRequest) {
		return userService.update(id, updateRequest);
	}
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

		//*************************PUPIL********************//

	//DONE
	@GetMapping("/pupils/{id}")
	public PupilResponse getPupil(@PathVariable Long id) {
		return pupilService.get(id);
	}

	//DONE
	@PostMapping("pupils/create")
	public ResponseEntity<Void> createPupil(@Valid @RequestBody PupilCreateRequest pupilCreateRequest) {
		pupilService.add(pupilCreateRequest);
		return ResponseEntity.ok().build();
	}

	//DONE
	@PutMapping("/pupils/set-year-mark/{id}")
	public ResponseEntity<Void> setYearMark(@PathVariable Long id, @Valid @RequestBody PupilSetMarkRequest setMarkRequest) {
		pupilService.setYearMark(id,setMarkRequest);
		return ResponseEntity.ok().build();
	}

	//DONE
	@PutMapping("/pupils/set-all-year-marks/{id}")
	public ResponseEntity<Void> setAllYearMarks(@PathVariable Long id) {
		pupilService.setAllYearMarks(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/pupils/set-amark/{id}")
	public ResponseEntity<Void> setMark(@PathVariable Long id, @Valid @RequestBody PupilSetMarkRequest setMarkRequest) {
		pupilService.setMark(id,setMarkRequest);
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
	public PupilResponse updatePupil(@PathVariable Long id, @Valid @RequestBody PupilUpdateRequest updateRequest){
		return pupilService.update(id, updateRequest);
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
	public EmployeeResponse createEmployee( @Valid @RequestBody EmployeeCreateRequest employeeCreateRequest) {
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
	public EmployeeResponse updateEmployee(@PathVariable Long id, @Valid @RequestBody EmployeeUpdateRequest updateRequest) {
		return employeeService.update(id,updateRequest);
	}

	@PutMapping("/employees/banking/{id}")
	public EmployeeResponse updateBanking(@PathVariable Long id, @Valid @RequestBody EmployeeBankingUpdateRequest bankingUpdateRequest) {
		return employeeService.updateBanking(id, bankingUpdateRequest);
	}

}
