package example.springframework.uno.repositories;

import example.springframework.uno.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
