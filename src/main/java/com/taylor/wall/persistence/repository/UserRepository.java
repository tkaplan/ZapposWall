package com.taylor.wall.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.taylor.wall.persistence.domain.User;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query(value = "select u.* from User u where u.email = :email", nativeQuery = true)
	User findByEmail(@Param("email") String email);
}
