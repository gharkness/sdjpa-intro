package com.gharkness.sdjpaintro.repositories;

import com.gharkness.sdjpaintro.domain.composite.AuthorEmbedded;
import com.gharkness.sdjpaintro.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorEmbeddedRepository extends JpaRepository<AuthorEmbedded, NameId> {
}
