package com.library;

import com.library.model.Book;
import com.library.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class LibraryManagementApplication {
    private static final Logger logger = LoggerFactory.getLogger(LibraryManagementApplication.class);

    public static void main(String[] args) {
        logger.info("Starting Library Management Application...");

        // Load Spring Application Context
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        logger.info("Spring Application Context loaded successfully");

        // Get BookService bean from Spring context
        BookService bookService = (BookService) context.getBean("bookService");
        logger.info("BookService bean retrieved from Spring context");

        // Test the application
        testLibraryOperations(bookService);

        // Close the context
        ((ClassPathXmlApplicationContext) context).close();
        logger.info("Application completed successfully");
    }

    private static void testLibraryOperations(BookService bookService) {
        logger.info("=== Testing Library Management Operations ===");

        // Display all books
        System.out.println("\n--- All Books in Library ---");
        List<Book> allBooks = bookService.getAllBooks();
        allBooks.forEach(System.out::println);

        // Add a new book
        System.out.println("\n--- Adding New Book ---");
        Book newBook = bookService.addBook("The Catcher in the Rye", "J.D. Salinger", "978-0-316-76948-0");
        System.out.println("Added: " + newBook);

        // Get book by ID
        System.out.println("\n--- Get Book by ID ---");
        Book bookById = bookService.getBookById(1L);
        System.out.println("Book with ID 1: " + bookById);

        // Get book by ISBN
        System.out.println("\n--- Get Book by ISBN ---");
        Book bookByIsbn = bookService.getBookByIsbn("978-0-7432-7356-5");
        System.out.println("Book with ISBN 978-0-7432-7356-5: " + bookByIsbn);

        // Borrow a book
        System.out.println("\n--- Borrowing Book ---");
        boolean borrowed = bookService.borrowBook(1L);
        System.out.println("Book borrowed successfully: " + borrowed);
        System.out.println("Book after borrowing: " + bookService.getBookById(1L));

        // Show available books
        System.out.println("\n--- Available Books ---");
        List<Book> availableBooks = bookService.getAvailableBooks();
        availableBooks.forEach(System.out::println);

        // Return the book
        System.out.println("\n--- Returning Book ---");
        boolean returned = bookService.returnBook(1L);
        System.out.println("Book returned successfully: " + returned);
        System.out.println("Book after returning: " + bookService.getBookById(1L));

        // Final count
        System.out.println("\n--- Final Book Count ---");
        System.out.println("Total books in library: " + bookService.getAllBooks().size());
    }
}
