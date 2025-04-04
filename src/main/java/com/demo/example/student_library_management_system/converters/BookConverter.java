package com.demo.example.student_library_management_system.converters;

import com.demo.example.student_library_management_system.model.Book;
import com.demo.example.student_library_management_system.requestdto.BookRequestDto;

public class BookConverter {
    public static Book convertBookRequestDtoIntoBook(BookRequestDto bookRequestDto){
        Book book = new Book();

        book.setTitle(bookRequestDto.getTitle());
        book.setAvailability(bookRequestDto.isAvailability());
        book.setPages(bookRequestDto.getPages());
        book.setPublisherName(bookRequestDto.getPublisherName());
        book.setCategory(bookRequestDto.getCategory());
        book.setPublishedDate(bookRequestDto.getPublishedDate());
        book.setEdition(bookRequestDto.getEdition());
        book.setPrice(bookRequestDto.getPrice());
        book.setRackNo(bookRequestDto.getRackNo());

        return book;
    }
}
