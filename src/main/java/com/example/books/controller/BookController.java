package com.example.books.controller;

import com.example.books.model.Book;
import com.example.books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(value="/test", method=RequestMethod.GET)
    public String test(){
        return "Merge";
    }

    @RequestMapping(value="/books",method= RequestMethod.POST)
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    @RequestMapping(value="/books",method=RequestMethod.GET)
    public List<Book> readBooks(){
        return bookService.getBooks();
    }

    @RequestMapping(value="/books/{bookId}",method = RequestMethod.GET)
    public Optional<Book> getBookById(@PathVariable(value="bookId") Long id){
        return bookService.getBookById(id);
    }

    @RequestMapping(value="/books/{bookId}", method=RequestMethod.PUT)
        public Book updateBook(@PathVariable(value="bookId") Long id,@RequestBody Book bookDetails){
        return bookService.updateBook(id, bookDetails);
    }

    @RequestMapping(value="/books/{IdOfBook}", method=RequestMethod.DELETE)
    public void deleteBook(@PathVariable(value="IdOfBook") Long id){
       bookService.deleteBook(id);
    }
}
