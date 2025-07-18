package com.library.service;

import com.library.model.Book;
import com.library.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);
    
    private BookRepository bookRepository;

    // Default constructor
    public BookService() {}

    // Constructor with BookRepository parameter
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(String title, String author, String isbn) {
        logger.info("Adding new book: {} by {}", title, author);
        Book book = new Book(null, title, author, isbn);
        return bookRepository.save(book);
    }

    public Book getBookById(Long id) {
        logger.info("Retrieving book with id: {}", id);
        return bookRepository.findById(id);
    }

    public List<Book> getAllBooks() {
        logger.info("Retrieving all books");
        return bookRepository.findAll();
    }

    public Book getBookByIsbn(String isbn) {
        logger.info("Retrieving book with ISBN: {}", isbn);
        return bookRepository.findByIsbn(isbn);
    }

    public boolean borrowBook(Long id) {
        Book book = bookRepository.findById(id);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            bookRepository.save(book);
            logger.info("Book borrowed: {}", book.getTitle());
            return true;
        } else {
            logger.warn("Book not available for borrowing. ID: {}", id);
            return false;
        }
    }

    public boolean returnBook(Long id) {
        Book book = bookRepository.findById(id);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            bookRepository.save(book);
            logger.info("Book returned: {}", book.getTitle());
            return true;
        } else {
            logger.warn("Book cannot be returned. ID: {}", id);
            return false;
        }
    }

    public void removeBook(Long id) {
        logger.info("Removing book with id: {}", id);
        bookRepository.deleteById(id);
    }

    public List<Book> getAvailableBooks() {
        logger.info("Retrieving available books");
        return bookRepository.findAll().stream()
                .filter(Book::isAvailable)
                .toList();
    }

    // Getter and Setter for bookRepository (used by Spring for dependency injection)
    public BookRepository getBookRepository() {
        return bookRepository;
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        logger.info("BookService configured with BookRepository");
    }
}
