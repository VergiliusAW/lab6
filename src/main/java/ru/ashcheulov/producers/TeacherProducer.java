package ru.ashcheulov.producers;

import ru.ashcheulov.pojo.Teacher;
import ru.ashcheulov.qualifiers.QTeacher;
import ru.ashcheulov.service.CRUDService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Produces;

@ApplicationScoped
public class TeacherProducer {

    @Inject
    EntityManager entityManager;

    @Produces
    @QTeacher
    public CRUDService<Teacher> teacherCRUDService() {
        return new CRUDService<>() {
            @Override
            public Teacher create(Teacher pojoObject) {
                entityManager.persist(pojoObject);
                entityManager.flush();
                return pojoObject;
            }

            @Override
            public Teacher read(Long id) {
                return entityManager.find(Teacher.class, id);
            }

            @Override
            public Teacher update(Teacher pojoObject) {
                entityManager.merge(pojoObject);
                entityManager.flush();
                return pojoObject;
            }

            @Override
            public Teacher delete(Teacher pojoObject) {
                var teacher = entityManager.find(Teacher.class, pojoObject.getId());
                entityManager.remove(teacher);
                return pojoObject;
            }

            @Override
            public Teacher init() {
                var teacher = new Teacher();
                teacher.setFio("Emhyr Var Emreis");
                teacher.setDepartment("Nilfgaard");
                teacher.setPosition("emperor");
                return teacher;
            }
        };
    }
}
