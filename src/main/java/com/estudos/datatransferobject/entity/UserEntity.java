package com.estudos.datatransferobject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Entity
@Table(name = "Usuarios", uniqueConstraints = {@UniqueConstraint(columnNames = {"cpf"})})
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Setter
    @Column(name = "nome", nullable = false)
    private String name;

    @Setter
    @Column(name = "idade", nullable = false)
    private int age;

    @Setter
    @Column(name = "cpf", nullable = false)
    private String cpf;

    @Setter
    @Column(name = "data_aniversario", nullable = false)
    private String dataAniversario;

}
