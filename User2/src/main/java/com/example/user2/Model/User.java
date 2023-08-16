package com.example.user2.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@NotNull(message = "The id field is required")
    private Integer id;
    @NotEmpty(message = "the name field is required ")
    @Size(min = 4,message = "The name length must be more than 4")
    private String name;
    @NotEmpty(message = "The username field is required")
    @Size(min = 4,message = "The user name length must be more than 4")
    @Column(columnDefinition = "Varchar(20) unique")
    private String username;
    @NotEmpty(message = "the password field is required ")
    private String password;
    @Email(message = "please enter valid email")
    @NotEmpty(message = "The email field is required")
    @Column(columnDefinition = "Varchar(20) unique")
    private String email;
    @Pattern(regexp = "(Admin)|(admin)|(User)|(user)",message ="the role must be admin or user " )
    @NotEmpty(message = "The role field is required")
    @Column(columnDefinition = "Varchar(20) check ( role='admin' or role='user')")
    private String role;
    @NotNull(message = "The age field is required")
    private Integer age;
}
