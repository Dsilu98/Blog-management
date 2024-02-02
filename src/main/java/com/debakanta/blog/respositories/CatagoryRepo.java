package com.debakanta.blog.respositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.debakanta.blog.entities.Catagory;
import com.debakanta.blog.entities.User;
@Repository
public interface CatagoryRepo extends JpaRepository<Catagory, Integer> {

}
