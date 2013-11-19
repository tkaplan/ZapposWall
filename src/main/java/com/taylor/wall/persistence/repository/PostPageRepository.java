package com.taylor.wall.persistence.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.taylor.wall.persistence.domain.Post;

public interface PostPageRepository extends PagingAndSortingRepository<Post, Long> {

}
