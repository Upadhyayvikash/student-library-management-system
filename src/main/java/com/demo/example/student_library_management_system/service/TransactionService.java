package com.demo.example.student_library_management_system.service;

import com.demo.example.student_library_management_system.converters.TransactionConverter;
import com.demo.example.student_library_management_system.model.Book;
import com.demo.example.student_library_management_system.model.Card;
import com.demo.example.student_library_management_system.model.Transaction;
import com.demo.example.student_library_management_system.repository.BookRepository;
import com.demo.example.student_library_management_system.repository.CardRepository;
import com.demo.example.student_library_management_system.repository.TransactionRepository;
import com.demo.example.student_library_management_system.requestdto.TransactionRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionService {
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    CardRepository cardRepository;

    public String addTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction=TransactionConverter.converterTransactionRequestDtoIntoTransaction(transactionRequestDto);

        // here we are taking foreign keys - cardId and bookId

        // get the book details using bookId
        Book book=bookRepository.findById(transactionRequestDto.getBookId()).get();
        transaction.setBook(book);
        // get the card details using cardId
        Card card=cardRepository.findById(transactionRequestDto.getCardId()).get();
        transaction.setCard(card);

        transactionRepository.save(transaction);
        return "Transaction saved successfully";
    }
}
