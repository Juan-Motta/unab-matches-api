package com.matches.repositories;

import com.matches.entities.Team;
import com.matches.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(nativeQuery = true, value="SELECT * FROM users WHERE id=:id")
    public User findUserById(Long id);

    public User findByUsername(String username);
}
