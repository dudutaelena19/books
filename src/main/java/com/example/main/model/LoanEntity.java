package com.example.main.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "loans", schema = "books_schema")
public class LoanEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "client_id", nullable = false)
    private int clientId;
    @Basic
    @Column(name = "book_id", nullable = false)
    private int bookId;

    @Basic
    @Column(name = "timestamp", nullable = true)
    private Timestamp timestamp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getClientId() {
        return clientId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoanEntity that = (LoanEntity) o;

        if (id != that.getId()) return false;
        if (clientId != that.getClientId()) return false;
        if (bookId != that.getBookId()) return false;
        if (timestamp != null ? !timestamp.equals(that.getTimestamp()) : that.getTimestamp() != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + clientId;
        result = 31 * result + bookId;
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        return result;
    }
}
