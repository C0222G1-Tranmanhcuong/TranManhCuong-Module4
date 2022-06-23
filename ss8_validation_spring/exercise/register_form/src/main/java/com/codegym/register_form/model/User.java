package com.codegym.register_form.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private Integer idUser;
    @Column(name = "first_name")
    @Size(min = 5, max = 45)
    @NotBlank(message = "Bạn phải nhập First name")
    private String firstName;
    @Column(name = "last_name")
    @NotBlank(message = "Bạn phải nhập Last name")
    private String lastName;
    @Column(name = "phone_number")
    @Pattern(regexp = "^[0-9]{9}$", message = "Số điện thoại bắt đầu từ 0 và có 9 số")
    private String phoneNumber;
    @Min(value = 18, message = "Tuổi lớn hơn 18")
    private Integer age;
    @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,2}$", message = "Email cần đúng định dạng")
    private String email;

    public User() {
    }

    public User(Integer idUser, @Size(min = 5, max = 45) @NotBlank(message = "Bạn phải nhập First name") String firstName,
                @NotBlank(message = "Bạn phải nhập First name") String lastName,
                @Pattern(regexp = "^[0-9]{9}$") String phoneNumber, @Min(value = 18, message = "Tuổi lớn hơn 18") Integer age,
                @Pattern(regexp = "^[A-Za-z0-9]+@[A-Za-z0-9]+(\\.[A-Za-z0-9]+){1,2}$") String email) {
        this.idUser = idUser;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}