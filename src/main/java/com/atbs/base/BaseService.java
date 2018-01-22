package com.atbs.base;

import org.springframework.stereotype.Component;

@Component
public interface BaseService<T extends BaseEntity> {

    Iterable<T> findAll();

    T findOne(Long id);

    <S extends T> T save(S entity);

    void delete(Long id);
}
