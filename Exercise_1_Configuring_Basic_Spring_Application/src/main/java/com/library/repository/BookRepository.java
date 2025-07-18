package com.library.repository;

import com.library.model.Book;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookRepository {
    private static final Logger logger = LoggerFactory.getLogger(BookRepository.class);
    
    private String dataSource;
    private Map<Long, Book> books;
    private Long nextId;

    public BookRepository() {
        this.books = new HashMap<>();
        this.nextId = 1L;
        initializeData();
    }

    // Initialize with some sample data
    private void initializeData() {
        save(new Book(null, "The Great Gatsby", "F. Scott Fitzgerald", "978-0-7432-7356-5"));
        save(new Book(null, "To Kill a Mockingbird", "Harper Lee", "978-0-06-112008-4"));
        save(new Book(null, "1984", "George Orwell", "978-0-452-28423-4"));
        logger.info("BookRepository initialized with sample data");
    }

    public Book save(Book book) {
        if (book.getId() == null) {
            book.setId(nextId++);
        }
        books.put(book.getId(), book);
        logger.info("Book saved: {}", book.getTitle());
        return book;
    }

    public Book findById(Long id) {
        Book book = books.get(id);
        if (book != null) {
            logger.info("Book found: {}", book.getTitle());
        } else {
            logger.warn("Book not found with id: {}", id);
        }
        return book;
    }

    public List<Book> findAll() {
        logger.info("Retrieving all books. Total count: {}", books.size());
        return new ArrayList<>(books.values());
    }

    public Book findByIsbn(String isbn) {
        Book foundBook = books.values().stream()
                .filter(book -> book.getIsbn().equals(isbn))
                .findFirst()
                .orElse(null);
        
        if (foundBook != null) {
            logger.info("Book found by ISBN {}: {}", isbn, foundBook.getTitle());
        } else {
            logger.warn("Book not found with ISBN: {}", isbn);
        }
        return foundBook;
    }

    public void deleteById(Long id) {
        Book removedBook = books.remove(id);
        if (removedBook != null) {
            logger.info("Book deleted: {}", removedBook.getTitle());
        } else {
            logger.warn("Attempted to delete non-existent book with id: {}", id);
        }
    }

    // Getter and Setter for dataSource (used by Spring for dependency injection)
    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
        logger.info("BookRepository configured with data source: {}", dataSource);
    }
}
