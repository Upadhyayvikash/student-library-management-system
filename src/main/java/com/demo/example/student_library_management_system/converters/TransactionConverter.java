package com.demo.example.student_library_management_system.converters;

import com.demo.example.student_library_management_system.model.Transaction;
import com.demo.example.student_library_management_system.requestdto.TransactionRequestDto;

public class TransactionConverter {
    public static Transaction converterTransactionRequestDtoIntoTransaction(TransactionRequestDto transactionRequestDto){
        Transaction transaction = new Transaction();
        transaction.setFine(transactionRequestDto.getFine());
        transaction.setDueDate(transactionRequestDto.getDueDate());
        transaction.setTransactionType(transactionRequestDto.getTransactionType());
        return transaction;
    }
}
