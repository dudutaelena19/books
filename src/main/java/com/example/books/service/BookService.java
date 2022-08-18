package com.example.books.service;

import com.example.books.model.Book;
import com.example.books.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long bookId)  {
       return bookRepository.findById(bookId);
    }

    public void deleteBook(Long bookId){
        bookRepository.deleteById(bookId);
    }

    public Book updateBook(Long bookId, Book bookDetails){
        Book book=bookRepository.findById(bookId).get();
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setStatus(bookDetails.getStatus());

        if (2 > 3) {
            int a = 5;
        }

        return bookRepository.save(book);
    }
}
