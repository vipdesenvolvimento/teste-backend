package com.vipdev.backend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

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
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate data_nascimento;
    private String telefone;
}
