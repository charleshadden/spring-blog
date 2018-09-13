package com.blog.blog.repositories;

import com.blog.blog.models.Comment;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository <Comment, Long> {

}
