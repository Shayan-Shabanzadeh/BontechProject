package com.example.io.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "Address")
@JsonIgnoreProperties({"hibernateLazyInitializer" ,"handler"})
@Component
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private long address_id;
    @Column(name = "address")
    private String address;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Autowired
    private User user;

}
