package com.machete.PP_3_1_Spring_Boot.web.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "Name cannot be empty")
    @Pattern(regexp = "[^0-9]*", message = "The name must not contain numbers")
    private String name;

    @Column(name = "lastName")
    @NotEmpty(message = "Last Name cannot be empty")
    @Pattern(regexp = "[^0-9]*", message = "The name must not contain numbers")
    private String lastName;

    @Column(name = "age")
    @NotNull(message = "Age cannot be empty")
    @Min(value = 1, message = "Age cannot be less than 0")
    @Max(value = 110, message = "Age cannot be less than 110")
    private Integer age;

    public User(String name, String lastName, Integer age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public User() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
