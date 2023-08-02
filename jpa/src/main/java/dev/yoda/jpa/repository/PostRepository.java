package dev.yoda.jpa.repository;

import dev.yoda.jpa.entity.BoardEntity;
import dev.yoda.jpa.entity.PostEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<PostEntity, Long> {

}
