package example.springframework.uno.bootstrap;

import example.springframework.uno.domain.Author;
import example.springframework.uno.domain.Book;
import example.springframework.uno.domain.Publisher;
import example.springframework.uno.repositories.AuthorRepository;
import example.springframework.uno.repositories.BookRepository;
import example.springframework.uno.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;

    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Start in Bootstrap");

        Publisher publisher = new Publisher();
        publisher.setName("Publicador Uno");
        publisher.setAddressLine1("Rua: Uno, n 1");
        publisher.setCity("Uno Town");
        publisher.setState("Uno State");
        publisher.setZip("00000-1");

        publisherRepository.save(publisher);

        System.out.println("Number of Publishers: " +publisherRepository.count());

        Author  raimundo = new Author("Raimundo", "Jose");
        Book livro = new Book("Vai filhao", "696969");
        raimundo.getBooks().add(livro);
        livro.getAuthors().add(raimundo);
        livro.setPublisher(publisher);
        publisher.getBooks().add(livro);

        authorRepository.save(raimundo);
        bookRepository.save(livro);
        publisherRepository.save(publisher);

        Author  erica = new Author("Erica", "Love in Love");
        Book diario = new Book("Bom dia", "707070");
        erica.getBooks().add(diario);
        diario.getAuthors().add(erica);
        diario.setPublisher(publisher);
        publisher.getBooks().add(diario);

        authorRepository.save(erica);
        bookRepository.save(diario);
        publisherRepository.save(publisher);

        System.out.println("Number of Books: " +bookRepository.count());
        System.out.println("Publisher Number of Books: " + publisher.getBooks().size());
    }
}
