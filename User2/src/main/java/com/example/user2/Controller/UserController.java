package com.example.user2.Controller;

import com.example.user2.ApiResponse.ApiResponce;
import com.example.user2.Model.User;
import com.example.user2.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
private final UserService userService;
    @GetMapping("/getall")
    public ResponseEntity getAll()
    {
        return ResponseEntity.status(200).body(userService.getAllUser());
    }
    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user, Errors error )
    {
        if(error.hasErrors())
        {
            String message=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        userService.addUser(user);
        return ResponseEntity.status(200).body(new ApiResponce("the User is added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateUser(@Valid @RequestBody User user,@PathVariable Integer id, Errors error)
    {
        if(error.hasErrors())
        {
            String message=error.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(userService.updateUser(id,user))
        {
            return ResponseEntity.status(200).body(new ApiResponce("the User is updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("wrong id"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id)
    {
        if(userService.deleteUser(id))
        {
            return ResponseEntity.status(200).body(new ApiResponce("the User is deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponce("wrong id"));
    }
}
