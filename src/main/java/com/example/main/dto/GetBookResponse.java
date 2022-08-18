package com.example.main.dto;

import com.example.main.model.BookEntity;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GetBookResponse {
    private BookEntity book;
    private String message;
}
