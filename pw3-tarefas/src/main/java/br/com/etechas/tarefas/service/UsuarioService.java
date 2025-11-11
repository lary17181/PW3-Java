package br.com.etechas.tarefas.service;

import br.com.etechas.tarefas.dto.UsuarioCadastroDTO;
import br.com.etechas.tarefas.dto.UsuarioResponseDTO;
import br.com.etechas.tarefas.entity.Tarefa;
import br.com.etechas.tarefas.entity.Usuario;
import br.com.etechas.tarefas.enums.RoleEnum;
import br.com.etechas.tarefas.mapper.TarefaMapper;
import br.com.etechas.tarefas.mapper.UsuarioMapper;
import br.com.etechas.tarefas.repository.TarefaRepository;
import br.com.etechas.tarefas.repository.UsuarioRepository;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {
    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private UsuarioMapper mapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UsuarioResponseDTO registrar(UsuarioCadastroDTO dto){

        Optional <Usuario> usuarioOptional=repository.findByUsername(dto.username());

        if (usuarioOptional.isPresent()){
            throw new RuntimeException("esse nome ja existe");
        }else{
            var senhaCifrada = passwordEncoder.encode(dto.password());
            Usuario saved = mapper.toEntity(dto);
            repository.save(saved);


            return mapper.toUsuarioResponseDTO(saved);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        return repository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado com username: " + username));
    }
}
