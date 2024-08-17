package satoripop.spring.satoripop_spring.services;

import org.springframework.stereotype.Service;
import satoripop.spring.satoripop_spring.domain.Book;
import satoripop.spring.satoripop_spring.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Iterable<Book> findAll() {
        return this.bookRepository.findAll();
    }
}
