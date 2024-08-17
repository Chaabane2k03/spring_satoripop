package satoripop.spring.satoripop_spring.repositories;

import org.springframework.data.repository.CrudRepository;
import satoripop.spring.satoripop_spring.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
