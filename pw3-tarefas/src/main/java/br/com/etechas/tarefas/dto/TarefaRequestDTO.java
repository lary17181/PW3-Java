package br.com.etechas.tarefas.dto;

import br.com.etechas.tarefas.enums.StatusEnum;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

public class TarefaRequestDTO {
    private String titulo;
    private String descricao;
    private String responsavel;
    private LocalDate dataLimite;
    private StatusEnum status;

    public String getTitulo()
    {
        return titulo;
    }
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao)
    {
        this.descricao = descricao;
    }

    public String getResponsavel()
    { return responsavel;
    }
    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }

    public LocalDate getDataLimite() {
        return dataLimite;
    }
    public void setDataLimite(LocalDate dataLimite) {
        this.dataLimite = dataLimite;
    }

    public StatusEnum getStatus() {
        return status;
    }
    public void setStatus(StatusEnum status) {
        this.status = status;
    }
}
