package com.sakshi.rest.webservices.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sakshi.rest.webservices.restfulwebservices.user.post.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer>{

}
