package org.spring_core.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Date;
@Data
@ToString
@NoArgsConstructor
public class Trainee {
    private long id;
    private LocalDate date;

    private String Address;
    private User user;

    public Trainee(long traineeId, LocalDate date, String address) {
        this.id = traineeId;
        this.date = date;
        Address = address;
    }

}
