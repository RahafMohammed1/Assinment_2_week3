package com.example.user2.Service;

import com.example.user2.Model.User;
import com.example.user2.Repsitiry.UserRepositiry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepositiry userRepositiry;
    public List<User> getAllUser() {
        return userRepositiry.findAll();
    }
    public void addUser(User user) {
        userRepositiry.save(user);
    }

    public Boolean updateUser(Integer id, User user) {
        User oldUser = userRepositiry.getById(id);
        if (oldUser == null) {
            return false;
        }
        oldUser.setId(id);
        oldUser.setName(user.getName());
        oldUser.setAge(user.getAge());
        oldUser.setUsername(user.getUsername());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setRole(user.getRole());
        userRepositiry.save(oldUser);
        return true;
    }

    public Boolean deleteUser(Integer id) {
        User oldUser = userRepositiry.getById(id);
        if (oldUser == null) {
            return false;
        }
        userRepositiry.delete(oldUser);
        return true;

    }



}
