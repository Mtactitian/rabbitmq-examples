package com.alexb.empconsumer.dto;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
public class EmployeeDto {

    private String name;

    private String job;

    private Integer managerId;

    private LocalDate hideDate;

    private Double salary;

    private Double commission;

    private Integer departmentNumber;

}
