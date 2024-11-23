package com.gharkness.sdjpaintro.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.util.Objects;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BookUuid {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(columnDefinition = "VARBINARY(16)", updatable = false, nullable = false)
    private UUID id;

    private String title;
    private String isbn;
    private String publisher;
}
