package com.gharkness.sdjpaintro.domain.composite;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@IdClass(NameId.class)
public class AuthorComposite {
    @Id
    private String firstName;
    @Id
    private String lastName;
    private String country;
}
