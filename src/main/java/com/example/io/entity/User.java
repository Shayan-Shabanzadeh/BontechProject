package com.example.io.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Component
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long user_id;
    @Column(name = "username")
    private String username;
    @Column(name = "email")
    private String email;
    @Column(name = "country")
    private String country;
    @OneToMany(mappedBy = "address", cascade =CascadeType.ALL)
    @Autowired
    private ArrayList<Address> address;

}
