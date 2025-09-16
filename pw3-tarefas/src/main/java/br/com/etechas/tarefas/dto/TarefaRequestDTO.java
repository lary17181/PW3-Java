package br.com.etechas.tarefas.dto;

import br.com.etechas.tarefas.enums.StatusEnum;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public record TarefaRequestDTO (
    String titulo,
    String descricao,
    String responsavel,
    LocalDate dataLimite,
    StatusEnum status
){
}