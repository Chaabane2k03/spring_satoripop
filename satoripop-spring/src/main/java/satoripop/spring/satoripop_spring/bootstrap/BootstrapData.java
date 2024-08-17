package satoripop.spring.satoripop_spring.bootstrap;


import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import satoripop.spring.satoripop_spring.domain.Author;
import satoripop.spring.satoripop_spring.domain.Book;
import satoripop.spring.satoripop_spring.domain.Publisher;
import satoripop.spring.satoripop_spring.repositories.AuthorRepository;
import satoripop.spring.satoripop_spring.repositories.BookRepository;
import satoripop.spring.satoripop_spring.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        //Author 1 :
        Author author = new Author();
        author.setFirstName("James");
        author.setLastName("Doe");
        Author authorSaved = authorRepository.save(author);

        //Book 1 :
        Book book = new Book();
        book.setTitle("The Book");
        book.setIsbn("978-3-16-148410-0");
        Book bookSaved = bookRepository.save(book);

        //Author 2 and his book :

        Author auteur = new Author();
        auteur.setFirstName("Chaabane");
        auteur.setLastName("Boussadia");
        Author authorSaved2 = authorRepository.save(auteur);

        //Book 2 :
        Book book1 = new Book();
        book1.setTitle("The Livre");
        book1.setIsbn("978-3-15-148410-1");
        Book bookSaved2 = bookRepository.save(book1);


        // Publisher :
        Publisher publisher = new Publisher();
        publisher.setPublisherName("The Publisher");
        publisher.setAddress("123 main");
        publisher.setCity("London");
        Publisher publisherSaved = publisherRepository.save(publisher);

        // Setting Up
        authorSaved.getBooks().add(bookSaved);
        authorSaved2.getBooks().add(bookSaved2);
        bookSaved.getAuthors().add(authorSaved);
        bookSaved2.getAuthors().add(authorSaved2);
        bookSaved.setPublisher(publisherSaved);
        bookSaved2.setPublisher(publisherSaved);


        //Saving :
        bookRepository.save(bookSaved);
        bookRepository.save(bookSaved2);

        authorRepository.save(authorSaved);
        authorRepository.save(authorSaved2);


        //Tests :
        System.out.println("We're in Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());


    }
}
