package com.uc.ms_security.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "sessions")
@Getter
@Setter
@NoArgsConstructor
public class Session {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    private Long id;

    @Column(
            nullable = false,
            length = 255
    )
    private String token;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(
            nullable = false
    )
    private Date expiration;

    @Column(
            length = 10
    )
    private String code2FA;
}
