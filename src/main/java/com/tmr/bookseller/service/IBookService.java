package com.tmr.bookseller.service;

import com.tmr.bookseller.model.Book;

import java.util.List;

public interface IBookService {
    public Book saveBook(Book book);

    void deleteBook(Long id);

    List<Book> findAllBooks();
}
