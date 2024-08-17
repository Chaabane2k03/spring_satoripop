package satoripop.spring.satoripop_spring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import satoripop.spring.satoripop_spring.services.BookService;

@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }


    @RequestMapping("/books")
    public String getBooks(Model model) {

        model.addAttribute("books" , bookService.findAll());
        return "books";
    }
}
