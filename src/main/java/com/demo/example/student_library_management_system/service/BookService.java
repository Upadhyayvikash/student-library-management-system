package com.demo.example.student_library_management_system.service;

import com.demo.example.student_library_management_system.converters.BookConverter;
import com.demo.example.student_library_management_system.model.Author;
import com.demo.example.student_library_management_system.model.Book;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.repository.AuthorRepository;
import com.demo.example.student_library_management_system.repository.BookRepository;
import com.demo.example.student_library_management_system.repository.CardRepository;
import com.demo.example.student_library_management_system.requestdto.BookRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private CardRepository cardRepository;

    public String addBook(BookRequestDto bookRequestDto){
        Book book=BookConverter.convertBookRequestDtoIntoBook(bookRequestDto);

        // here we have foreign keys authorId and cardId as well

        // using the authorId take the whole details of the author from the authorRepository
        Author author=authorRepository.findById(bookRequestDto.getAuthorId()).get();
        book.setAuthor(author);

        // using the cardId take the whole details of the card from the cardRepository
        Card card=cardRepository.findById(bookRequestDto.getCardId()).get();
        book.setCard(card);

        bookRepository.save(book);
        return "Book saved successfully";
    }
}
