package satoripop.spring.satoripop_spring.services;


import satoripop.spring.satoripop_spring.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
