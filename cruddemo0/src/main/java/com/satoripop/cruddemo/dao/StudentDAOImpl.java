package com.satoripop.cruddemo.dao;

import com.satoripop.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public class StudentDAOImpl implements StudentDAO{
    //define fields for entity
    private EntityManager em;
    //Inject entity manager in the constructor
    @Autowired
    public StudentDAOImpl(EntityManager em) {
        this.em = em;
    }
    //Implement save method
    @Override
    @Transactional
    public void save(Student student) {
        em.persist(student);
    }

    @Override
    @Transactional
    public Student findById(int id) {
        return em.find(Student.class, id);
    }


    @Override
    @Transactional
    public List<Student> findAll() {
        TypedQuery<Student> query = em.createQuery("FROM Student ORDER BY lastName DESC ", Student.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public List<Student> findByLastName(String lastName) {
        TypedQuery<Student> query = em.createQuery("FROM Student WHERE lastName = :lastName", Student.class);
        query.setParameter("lastName", lastName);
        return query.getResultList();
    }


    @Override
    @Transactional
    public void update(Student student) {
        em.merge(student);
    }


    @Override
    @Transactional
    public void delete(int id) {
        Student student = em.find(Student.class, id);
        if (student != null) {
            em.remove(student);
        }
        else{
            System.out.println("Student not found");
        }
    }

    @Override
    @Transactional
    public void deleteAll(){
        int rows = em.createQuery("DELETE FROM Student")
                .executeUpdate();

        System.out.println("Deleted all students . . . :" + rows + "are deleted");
    }


}
