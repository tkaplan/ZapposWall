package com.taylor.wall.persistence.repository;

import org.springframework.data.repository.CrudRepository;

import com.taylor.wall.persistence.domain.Post;

public interface PostRepository extends CrudRepository<Post, Long> {
}
