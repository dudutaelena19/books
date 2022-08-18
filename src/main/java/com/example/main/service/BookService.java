package com.example.main.service;

import com.example.main.dto.GetBookResponse;
import com.example.main.model.BookEntity;
import com.example.main.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public BookEntity createBook(BookEntity book){
        return bookRepository.save(book);
    }

    public List<BookEntity> getBooks(){
        return bookRepository.findAll();
    }

    public GetBookResponse getBookById(Integer bookId)  {
        Optional<BookEntity> optionalBook= bookRepository.findById(bookId);

        if (optionalBook.isPresent()) {
            return new GetBookResponse(optionalBook.get(), null);
        } else {
            return new GetBookResponse(null, "No such book found");
        }
    }

    public void deleteBook(Integer bookId){
        bookRepository.deleteById(bookId);
    }

    public BookEntity updateBook(Integer bookId, BookEntity bookDetails){
        bookDetails.setId(bookId);
        return bookRepository.save(bookDetails);
    }

    public List<String> getFilteredBooks() {
        List<BookEntity> books = getBooks();
//        List<String> authors = new ArrayList<>();
//
//        for (BookEntity book : books) {
//            if (!book.getOnLoan() && book.getAuthor().length() == 5) {
//                authors.add(book.getAuthor());
//            }
//        }
//
//        return authors;

        return books.stream()
                .filter(book -> !book.getOnLoan())
                .map(BookEntity::getAuthor)
                .filter(author -> author.length() == 5)
                .collect(Collectors.toList());
    }
}
