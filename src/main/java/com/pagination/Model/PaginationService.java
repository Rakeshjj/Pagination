package com.pagination.Model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PaginationService {
	
	@Autowired
	private StudentRepo studentRepo;

	public Student save(Student student) {
		return studentRepo.save(student);
	}

	public List<Student> getAll(int pageNo,int pageSize) {
		Pageable pageable=PageRequest.of(pageNo, pageSize,Sort.by("name"));
		return studentRepo.findAll(pageable).get().toList();
	}

//	public List<Student> getEmpName(String name,int pageNo,int pageSize) {
//		Pageable pageable=PageRequest.of(pageNo, pageSize);
//		return studentRepo.findAll(name,pageable);
//	}
}
