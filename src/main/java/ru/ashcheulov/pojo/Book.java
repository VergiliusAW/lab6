package ru.ashcheulov.pojo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "book")
public class Book implements BasePojo {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_generator")
    @SequenceGenerator(name = "book_generator", sequenceName = "book_seq", allocationSize = 10, initialValue = 50)
    private Long id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String author;
}
