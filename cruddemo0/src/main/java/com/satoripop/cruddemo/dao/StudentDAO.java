package com.satoripop.cruddemo.dao;

import com.satoripop.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String name);
    void update(Student student);
    void delete(int id);
    void deleteAll();

}
