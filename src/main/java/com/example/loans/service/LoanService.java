package com.example.loans.service;

import com.example.loans.model.Loan;
import com.example.loans.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoanService {

    @Autowired
    LoanRepository loanRepository;

    public Loan createLoan(Loan loan){
        return loanRepository.save(loan);
    }

    public List<Loan> getLoans(){
        return loanRepository.findAll();
    }

    public void deleteLoan(long loanId){
        loanRepository.deleteById(loanId);
    }

    public Loan updateLoan(Long loanId, Loan loanDetails){
        Loan loan=loanRepository.findById(loanId).get();
        loan.setBookId(loanDetails.getBookId());
        loan.setTimestamp(loan.getTimestamp());
        loan.setCustomerId(loan.getCustomerId());
        return loanRepository.save(loan);
    }
}
