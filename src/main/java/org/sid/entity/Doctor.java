package org.sid.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String specialty;
    private String email;
    private String phone;
    @Column(nullable = false)
    private String city;
    @Column(nullable = false)
    private String country;
    @Column(nullable = false)
    private String address;
}

