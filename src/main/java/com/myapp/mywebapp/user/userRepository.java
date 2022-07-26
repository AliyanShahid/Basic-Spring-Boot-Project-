package com.myapp.mywebapp.user;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface userRepository extends CrudRepository <user,Integer> {



    @Override
    <S extends user> Iterable<S> saveAll(Iterable<S> entities);

    @Override
    Optional<user> findById(Integer integer);

    @Override
    boolean existsById(Integer integer);

    @Override
    Iterable<user> findAll();

    @Override
    Iterable<user> findAllById(Iterable<Integer> integers);

    @Override
    long count();

    @Override
    void deleteById(Integer integer);

    @Override
    void delete(user entity);

    @Override
    void deleteAllById(Iterable<? extends Integer> integers);

    @Override
    void deleteAll(Iterable<? extends user> entities);

    @Override
    void deleteAll();
}
