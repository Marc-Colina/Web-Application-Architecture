package com.example.waa_lab_7_back_end.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExceptionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long transactionId;

    LocalDate date;
    LocalTime time;
    String principle;
    String operation;
    String exceptionType;

}
