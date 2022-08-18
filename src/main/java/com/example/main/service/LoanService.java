package com.example.main.service;

import com.example.main.dto.GetBookResponse;
import com.example.main.model.BookEntity;
import com.example.main.model.LoanEntity;
import com.example.main.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookService bookService;

    @Autowired
    public LoanService(LoanRepository loanRepository, BookService bookService) {
        this.loanRepository = loanRepository;
        this.bookService = bookService;
    }

    public LoanEntity createLoan(LoanEntity loan){
        return loanRepository.save(loan);
    }

    public List<LoanEntity> getLoans(){
        return loanRepository.findAll();
    }

    public void deleteLoan(Integer loanId){
        loanRepository.deleteById(loanId);
    }

    public LoanEntity updateLoan(Integer loanId, LoanEntity loanDetails){
        LoanEntity loan = loanRepository.findById(loanId).get();
        loan.setBookId(loanDetails.getBookId());
        loan.setTimestamp(loan.getTimestamp());
        loan.setClientId(loan.getClientId());
        return loanRepository.save(loan);
    }

    public boolean tryLoan(int bookId, int clientId) {
        GetBookResponse book = bookService.getBookById(bookId);

        if (book.getBook() == null) {
            return false;
        }

        BookEntity bookEntity = book.getBook();
        if (bookEntity.getOnLoan()) {
            return false;
        }

        bookEntity.setOnLoan(true);
        bookService.updateBook(bookId, bookEntity);
        return true;
    }
}
