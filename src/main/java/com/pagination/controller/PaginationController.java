package com.pagination.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pagination.Model.PaginationService;
import com.pagination.Model.Student;
import com.pagination.Model.StudentRepo;

@RestController
@RequestMapping("/api")
public class PaginationController {

	@Autowired
	private StudentRepo studentRepo;

	private PaginationService paginationService;

	public PaginationController(PaginationService paginationService) {
		super();
		this.paginationService = paginationService;
	}

	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Student student) {
		paginationService.save(student);
		return ResponseEntity.ok("Data saved Sucess!!");
	}

	@GetMapping("/getAll")
	public List<Student> get1() {
		return studentRepo.findAll();

	}
	
	@GetMapping
	public String get() {
		return "Hello world";
	}

	@GetMapping("/getAll/{pageNo}/{pageSize}")
	public ResponseEntity<List<Student>> getAll(@PathVariable int pageNo, @PathVariable int pageSize) {
		List<Student> students = paginationService.getAll(pageNo, pageSize);
		return ResponseEntity.ok(students);
	}

//	@GetMapping("/getAll/{name}/{pageNo}/{pageSize}")
//	public List<Student> getName(@PathVariable String name, @PathVariable int pageNo, @PathVariable int pageSize) {
//		return paginationService.getEmpName(name, pageNo, pageSize);
//	}

//	@GetMapping("/get")
//	public Page<Student> getpage(@RequestBody Pagination pagination) {
//		Pageable pageable = pagination.getPageableData(pagination);
//		return studentRepo.findAll(pageable);
//
//	}

}
