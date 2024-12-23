package com.gharkness.sdjpaintro.domain.composite;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="author_composite")
public class AuthorEmbedded {
    @EmbeddedId
    private NameId nameId;
    private String country;

    public AuthorEmbedded(NameId nameId) {
        this.nameId = nameId;
    }
}
