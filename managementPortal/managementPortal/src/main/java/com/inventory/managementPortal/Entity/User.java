package com.inventory.managementPortal.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(unique = true)
    @NotNull
    private String Username;

    @Size(min = 8, max = 25)
    @NotNull
    private String password;

    @NotNull
    private String userType;

    @Length(min = 10)
    @NotNull
    private String mobileNumber;

    @Email
    @Column(unique = true)
    @NotNull
    private String emailId;

    @NotNull
    private String dob;

}