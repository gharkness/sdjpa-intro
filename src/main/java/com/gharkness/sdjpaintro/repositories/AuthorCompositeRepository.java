package com.gharkness.sdjpaintro.repositories;

import com.gharkness.sdjpaintro.domain.composite.AuthorComposite;
import com.gharkness.sdjpaintro.domain.composite.NameId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorCompositeRepository extends JpaRepository<AuthorComposite, NameId> {
}
