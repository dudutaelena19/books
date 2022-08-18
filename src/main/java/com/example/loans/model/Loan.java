package com.example.loans.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="id")
    private Long id;

    @Column(name="customer_id")
    private Long customerId;

    @Column(name="book_id")
    private Long bookId;

    @Column(name="timestamp_of_loan")
    private Date timestamp;

    public Long getId() {
        return id;
    }



    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getBookId() {
        return bookId;
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }
}
