package com.alexb.empconsumer.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "dept")
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@Setter
@Getter
public class Department {
    @Id
    @GeneratedValue
    @Column(name = "deptno")
    private Integer id;

    @Column(name = "dname")
    private String name;

    @Column(name = "loc")
    private String location;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "department", orphanRemoval = true)
    private List<Employee> employees;
}
