package com.pagination.Model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {

//	List<Student> findAll(String name, Pageable pageable);

}
