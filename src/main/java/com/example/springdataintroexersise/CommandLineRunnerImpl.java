package com.example.springdataintroexersise;

import com.example.springdataintroexersise.model.entity.Book;
import com.example.springdataintroexersise.service.AuthorService;
import com.example.springdataintroexersise.service.BookService;
import com.example.springdataintroexersise.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();

        //MethodOne();
        //MethodTwo();
        //MethodThree();
        //MethodN();
    }

    private void printAllBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService.findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);

    }


    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService.getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);

    }

    private void printAllAuthorsNamesWithBooksBeforeReleaseDate(int year) {
        bookService.findAllAuthorsWithBooksReleasedDate(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterDate(int year) {
        bookService.findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }
}
