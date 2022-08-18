package com.example.main.controller;

import com.example.main.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoanController {
    @Autowired
    LoanService loanService;

    @PostMapping("/loan")
    public boolean tryLoan(
            @RequestParam("bookId") int bookId,
            @RequestParam("clientId") int clientId
    ) {
        return loanService.tryLoan(bookId, clientId);
    }
}