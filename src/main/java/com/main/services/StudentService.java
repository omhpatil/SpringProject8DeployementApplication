package com.main.services;

import java.util.List;

import com.main.entities.Student;

public interface StudentService {

	public boolean addStudnetDetails(Student std);
	public List<Student> getAllStdDetails();
	public Student getStdDetails(long id);
	public boolean updateStdDetails(long id, float marks);
	public boolean deleteStdDetails(long id);

}
