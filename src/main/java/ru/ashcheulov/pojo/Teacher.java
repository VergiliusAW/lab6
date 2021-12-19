package ru.ashcheulov.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "teacher")
public class Teacher implements BasePojo {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_generator")
    @SequenceGenerator(name = "teacher_generator", sequenceName = "teacher_seq", allocationSize = 10)
    private Long id;

    @Getter
    @Setter
    private String fio;

    @Getter
    @Setter
    private String position;

    @Getter
    @Setter
    private String department;
}
