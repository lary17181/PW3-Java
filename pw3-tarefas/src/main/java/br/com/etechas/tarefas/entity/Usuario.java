package br.com.etechas.tarefas.entity;

import br.com.etechas.tarefas.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private RoleEnum role;
}
