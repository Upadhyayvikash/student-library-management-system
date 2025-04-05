package com.demo.example.student_library_management_system.model;

import com.demo.example.student_library_management_system.enums.CardStatus;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name="card")
public class Card {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="card_status",nullable = false)
    @Enumerated(value=EnumType.STRING)
    private CardStatus cardStatus;
    @Column(name="blood_group",nullable = false)
    private String bloodGroup;
    @Column(name="created_date",nullable = false)
    @CreationTimestamp
    private Date createdDate;
    @Column(name="updated_date",nullable = false)
    @UpdateTimestamp
    private Date updateDAte;

    @JsonBackReference
    @JoinColumn // it joins the primary key student id of student table as a foreign key in card table
    @OneToOne // one card is assigned to one student(we have one to one relation between card and student)
    private Student student1;
    @JsonManagedReference
    @OneToMany(mappedBy = "card")
    private List<Book> bookList;
    @JsonManagedReference
    @OneToMany(mappedBy = "card")
    private List<Transaction> transactionList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CardStatus getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(CardStatus cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDAte() {
        return updateDAte;
    }

    public void setUpdateDAte(Date updateDAte) {
        this.updateDAte = updateDAte;
    }

    public Student getStudent1() {
        return student1;
    }

    public void setStudent1(Student student1) {
        this.student1 = student1;
    }

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }
}
