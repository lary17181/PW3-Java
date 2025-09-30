package br.com.etechas.tarefas.controller;

import br.com.etechas.tarefas.dto.TarefaRequestDTO;
import br.com.etechas.tarefas.dto.TarefaResponseDTO;
import br.com.etechas.tarefas.dto.UsuarioCadastroDTO;
import br.com.etechas.tarefas.dto.UsuarioResponseDTO;
import br.com.etechas.tarefas.service.TarefaService;
import br.com.etechas.tarefas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")

public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping
    public ResponseEntity<UsuarioResponseDTO> Cadastrar(@RequestBody UsuarioCadastroDTO dto){
        UsuarioResponseDTO saved = service.registrar(dto);
        return ResponseEntity.ok(saved);
    }
}
