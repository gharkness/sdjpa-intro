package com.gharkness.sdjpaintro.bootstrap;

import com.gharkness.sdjpaintro.domain.AuthorUuid;
import com.gharkness.sdjpaintro.domain.Book;
import com.gharkness.sdjpaintro.domain.BookUuid;
import com.gharkness.sdjpaintro.repositories.AuthorUuidRepository;
import com.gharkness.sdjpaintro.repositories.BookRepository;
import com.gharkness.sdjpaintro.repositories.BookUuidRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile({"local", "default"})
@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final BookRepository bookRepository;
    private final AuthorUuidRepository authorUuidRepository;
    private final BookUuidRepository bookUuidRepository;

    @Override
    public void run(String... args) throws Exception {
        bookRepository.deleteAll();

        Book bookDDD = new Book("Domain Driven Design", "1234", "Addison-Wesley", null);

        System.out.println("Id: " + bookDDD.getId());

        Book savedDDD = bookRepository.save(bookDDD);

        System.out.println("Id: " + savedDDD.getId());

        Book BookSIA = new Book("Spring in Action", "2345", "Manning", null);
        Book savedSIA = bookRepository.save(BookSIA);

        bookRepository.findAll().forEach(book -> {
            System.out.println("Book Id: " + book.getId());
            System.out.println("Book Title: " + book.getTitle());
        });

        AuthorUuid authorUuid = new AuthorUuid();
        authorUuid.setFirstName("George");
        authorUuid.setLastName("Costanza");
        AuthorUuid savedAuthorUuid = authorUuidRepository.save(authorUuid);
        System.out.println("Saved Author UUID: " + savedAuthorUuid.getId());

        BookUuid bookUuid = new BookUuid();
        bookUuid.setTitle("All About UUIDs");
        BookUuid savedBookUuid = bookUuidRepository.save(bookUuid);
        System.out.println("Saved Book UUID: " + savedBookUuid.getId());
    }
}
