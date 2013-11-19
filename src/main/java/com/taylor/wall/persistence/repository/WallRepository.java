package com.taylor.wall.persistence.repository;

import com.taylor.wall.persistence.domain.Wall;
import org.springframework.data.repository.CrudRepository;

public interface WallRepository extends CrudRepository<Wall, Long> {
}