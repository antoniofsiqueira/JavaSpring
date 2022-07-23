package example.springframework.uno.repositories;

import example.springframework.uno.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
