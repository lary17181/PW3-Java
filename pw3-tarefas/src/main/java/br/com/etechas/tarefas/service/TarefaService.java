package br.com.etechas.tarefas.service;

import br.com.etechas.tarefas.dto.TarefaResponseDTO;
import br.com.etechas.tarefas.entity.Tarefa;
import br.com.etechas.tarefas.enums.StatusEnum;
import br.com.etechas.tarefas.mapper.TarefaMapper;
import br.com.etechas.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.etechas.tarefas.dto.TarefaRequestDTO;

import java.util.Collections;
import java.util.List;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository repository;

    @Autowired
    private TarefaMapper tarefaMapper;

    public List<TarefaResponseDTO> findAll(){
        return tarefaMapper.toResponseDTOList(repository.findAll());
    }

    public TarefaResponseDTO save(TarefaRequestDTO dto){
        Tarefa tarefa = new Tarefa();
        tarefa.setTitulo(dto.getTitulo());
        tarefa.setDescricao(dto.getDescricao());
        tarefa.setResponsavel(dto.getResponsavel());
        tarefa.setDataLimite(dto.getDataLimite());
        tarefa.setStatus(StatusEnum.PENDING);

        Tarefa saved = repository.save(tarefa);
        return tarefaMapper.toResponseDTOList(Collections.singletonList(saved)).get(0);
    }

    public boolean deleteById(Long id){
        var tarefa = repository.findById(id);
        if(tarefa.isEmpty()){
            return false;
        }
        if (tarefa.get().isPending()) {
            repository.deleteById(id);
            return true;
        }
        throw new RuntimeException("Tarefa em progresso ou concluída");
    }
}
