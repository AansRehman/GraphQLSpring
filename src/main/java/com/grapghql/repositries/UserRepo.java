package com.grapghql.repositries;

import com.grapghql.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    //custom query methods
    //custom finder methods
}