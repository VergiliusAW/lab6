package ru.ashcheulov.service;

import ru.ashcheulov.pojo.Student;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@ApplicationScoped
public class StudentService {

    @Inject
    EntityManager entityManager;

    @Transactional
    public Student insertStudent(Student student) {
        entityManager.persist(student);
        entityManager.flush();
        return student;
    }

    @Transactional
    public Student updateStudent(Student student) {
        entityManager.merge(student);
        entityManager.flush();
        return student;
    }

    public List<Student> getStudents() {
        return entityManager.createQuery("select s from Student s", Student.class).getResultList();
    }

    public Student initStudent() {
        Student student = new Student();
        student.setBirthDate(new Date());
        student.setEmail("q@q.q");
        student.setInn(1213123L);
        student.setFio("Ivanov Ivan Ivanovich");
        return student;
    }

    @Transactional
    public Student deleteStudent(Student student) {
        var s = entityManager.find(Student.class, student.getId());
        entityManager.remove(s);
        entityManager.flush();
        return student;
    }
}
