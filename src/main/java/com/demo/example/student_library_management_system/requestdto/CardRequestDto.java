package com.demo.example.student_library_management_system.requestdto;

import com.demo.example.student_library_management_system.enums.CardStatus;


public class CardRequestDto {

    private CardStatus cardStatus;
    private String bloodGroup;
    private int student1Id;

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

    public int getStudent1Id() {
        return student1Id;
    }

    public void setStudent1Id(int student1Id) {
        this.student1Id = student1Id;
    }
}
