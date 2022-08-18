package com.example.main.controller;

import com.example.main.dto.GetBookResponse;
import com.example.main.model.BookEntity;
import com.example.main.service.BookService;
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
    public BookEntity createBook(@RequestBody BookEntity book){
        return bookService.createBook(book);
    }

    @RequestMapping(value="/books",method=RequestMethod.GET)
    public List<BookEntity> readBooks(){
        return bookService.getBooks();
    }

    @RequestMapping(value="/books/{bookId}",method = RequestMethod.GET)
    public GetBookResponse getBookById(@PathVariable(value="bookId") Integer id){
        return bookService.getBookById(id);
    }

    @RequestMapping(value="/books/{bookId}", method=RequestMethod.PUT)
        public BookEntity updateBook(@PathVariable(value="bookId") Integer id,@RequestBody BookEntity bookDetails){
        return bookService.updateBook(id, bookDetails);
    }


    @RequestMapping(value="/books/{IdOfBook}", method=RequestMethod.DELETE)
    public void deleteBook(@PathVariable(value="IdOfBook") Integer id){
       bookService.deleteBook(id);
    }

    @GetMapping("/books/filtered")
    public List<String> getFilteredBAuthors() {
        return bookService.getFilteredBooks();
    }
}
