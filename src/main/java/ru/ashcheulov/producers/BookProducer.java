package ru.ashcheulov.producers;

import ru.ashcheulov.pojo.Book;
import ru.ashcheulov.qualifiers.QBook;
import ru.ashcheulov.service.CRUDService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.ws.rs.Produces;

@ApplicationScoped
public class BookProducer {
    @Inject
    EntityManager entityManager;

    @Produces
    @QBook
    public CRUDService<Book> bookCRUDService() {
        return new CRUDService<>() {
            @Override
            public Book create(Book pojoObject) {
                entityManager.persist(pojoObject);
                entityManager.flush();
                return pojoObject;
            }

            @Override
            public Book read(Long id) {
                return entityManager.find(Book.class, id);
            }

            @Override
            public Book update(Book pojoObject) {
                entityManager.merge(pojoObject);
                entityManager.flush();
                return pojoObject;
            }

            @Override
            public Book delete(Book pojoObject) {
                var book = entityManager.find(Book.class, pojoObject.getId());
                entityManager.remove(book);
                return pojoObject;
            }

            @Override
            public Book init() {
                var book = new Book();
                book.setAuthor("Gilgamesh Camembert");
                book.setName("How to cheese");
                return book;
            }
        };
    }
}
