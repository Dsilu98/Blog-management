package com.debakanta.blog.respositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.Integer;

import com.debakanta.blog.entities.User;
@Repository
public interface UserRespo extends JpaRepository<User, Integer>{


}
