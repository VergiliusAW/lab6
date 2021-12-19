package ru.ashcheulov.service;

import ru.ashcheulov.pojo.BasePojo;

public interface CRUDService<T extends BasePojo> {

    T create(T pojoObject);

    default T read(Long id) {
        return init();
    }

    T update(T pojoObject);

    T delete(T pojoObject);

    T init();
}
