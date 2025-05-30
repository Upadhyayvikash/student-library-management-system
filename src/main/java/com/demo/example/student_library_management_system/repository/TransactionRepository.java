package com.demo.example.student_library_management_system.repository;

import com.demo.example.student_library_management_system.model.Author;
import com.demo.example.student_library_management_system.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
}
