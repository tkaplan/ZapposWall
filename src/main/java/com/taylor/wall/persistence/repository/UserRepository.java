package com.taylor.wall.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.taylor.wall.persistence.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
