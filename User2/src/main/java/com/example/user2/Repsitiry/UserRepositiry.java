package com.example.user2.Repsitiry;

import com.example.user2.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositiry extends JpaRepository <User, Integer> {
}
