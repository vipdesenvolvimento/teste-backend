package com.vipdev.backend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="lead")
public class Lead {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private int id;

    private String nome;
    private String sobrenome;
    private LocalDate data_nascimento;
    private String telefone;
}
