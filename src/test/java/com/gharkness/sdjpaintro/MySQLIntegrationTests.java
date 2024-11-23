package com.gharkness.sdjpaintro;

import com.gharkness.sdjpaintro.domain.AuthorUuid;
import com.gharkness.sdjpaintro.domain.BookNatural;
import com.gharkness.sdjpaintro.domain.BookUuid;
import com.gharkness.sdjpaintro.domain.composite.AuthorComposite;
import com.gharkness.sdjpaintro.domain.composite.AuthorEmbedded;
import com.gharkness.sdjpaintro.domain.composite.NameId;
import com.gharkness.sdjpaintro.repositories.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@ActiveProfiles("local")
@DataJpaTest
@ComponentScan(basePackages = {"com.gharkness.sdjpaintro.bootstrap"})
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class MySQLIntegrationTests {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookUuidRepository bookUuidRepository;

    @Autowired
    AuthorUuidRepository authorUuidRepository;

    @Autowired
    private BookNaturalRepository bookNaturalRepository;

    @Autowired
    AuthorCompositeRepository authorCompositeRepository;

    @Autowired
    AuthorEmbeddedRepository authorEmbeddedRepository;

    @Test
    void authorEmbeddedTest() {
        NameId nameId = new NameId("Garrett", "Harkness");
        AuthorEmbedded authorEmbedded = new AuthorEmbedded(nameId);

        AuthorEmbedded saved = authorEmbeddedRepository.save(authorEmbedded);
        assertThat(saved).isNotNull();

        AuthorEmbedded fetched = authorEmbeddedRepository.getReferenceById(nameId);
        assertThat(fetched).isNotNull();
    }

    @Test
    void authorCompositeTest() {
        NameId nameId = new NameId("Garrett", "Harkness");
        AuthorComposite authorComposite = new AuthorComposite();
        authorComposite.setFirstName(nameId.getFirstName());
        authorComposite.setLastName(nameId.getLastName());
        authorComposite.setCountry("USA");

        AuthorComposite saved = authorCompositeRepository.save(authorComposite);
        assertThat(saved).isNotNull();

        AuthorComposite fetched = authorCompositeRepository.getReferenceById(nameId);
        assertThat(fetched).isNotNull();
    }

    @Test
    void bookNaturalTest() {
        BookNatural bookNatural = new BookNatural();
        bookNatural.setTitle("Natural Key Book");
        BookNatural saved = bookNaturalRepository.save(bookNatural);

        BookNatural fetched = bookNaturalRepository.getReferenceById(saved.getTitle());
        assertThat(fetched).isNotNull();
    }

    @Test
    void testBookUuid() {
        BookUuid bookUuid = bookUuidRepository.save(new BookUuid());
        assertThat(bookUuid).isNotNull();
        assertThat(bookUuid.getId()).isNotNull();

        BookUuid fetched = bookUuidRepository.getReferenceById(bookUuid.getId());
        assertThat(fetched).isNotNull();
    }

    @Test
    void testAuthorUuid() {
        AuthorUuid authorUuid = authorUuidRepository.save(new AuthorUuid());
        assertThat(authorUuid).isNotNull();
        assertThat(authorUuid.getId()).isNotNull();

        BookUuid fetched = bookUuidRepository.getReferenceById(authorUuid.getId());
        assertThat(fetched).isNotNull();
    }

    @Test
    void testMySQL() {
        long countBefore = bookRepository.count();
        assertThat(countBefore).isEqualTo(2);
    }
}
