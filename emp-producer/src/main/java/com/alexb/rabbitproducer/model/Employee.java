package com.alexb.rabbitproducer.model;

import lombok.*;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class Employee {

    @Length(max = 10)
    private String name;

    @Length(max = 9)
    private String job;

    @Range(min = -9999, max = 9999)
    private Integer managerId;

    private LocalDate hideDate;

    @Digits(integer = 5, fraction = 2)
    private Double salary;

    @Digits(integer = 5, fraction = 2)
    private Double commission;

    @NotNull
    private Integer departmentNumber;

}
