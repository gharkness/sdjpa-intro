package com.gharkness.sdjpaintro.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;

import java.util.UUID;
import java.sql.Types;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthorUuid {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JdbcTypeCode(value = Types.VARCHAR)
    @Column(length = 36, columnDefinition = "VARCHAR(36)", updatable = false, nullable = false)
    private UUID id;

    private String firstName;

    private String lastName;
}
