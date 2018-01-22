package com.atbs.base;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public abstract class BaseServiceImpl<T extends BaseEntity> implements BaseService<T> {
    protected abstract BaseRepository<T> getRepository();

    @Transactional(readOnly = true)
    @Override
    public T findOne(Long id) {
        return getRepository().findOne(id);
    }

    @Transactional(readOnly = true)
    @Override
    public Iterable<T> findAll() {
        return getRepository().findAll();
    }

    @Transactional
    @Override
    public <S extends T> T save(S entity) {
        return getRepository().save(entity);
    }

    @Transactional
    @Override
    public void delete(Long id) {
        getRepository().delete(id);
    }
}
