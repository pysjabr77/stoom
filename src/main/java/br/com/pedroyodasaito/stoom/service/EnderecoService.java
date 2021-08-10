package br.com.pedroyodasaito.stoom.service;

import br.com.pedroyodasaito.stoom.api.v1.EnderecoInserirDTO;
import br.com.pedroyodasaito.stoom.entity.Endereco;

import java.util.List;
import java.util.Optional;

public interface EnderecoService {

    Endereco insert(EnderecoInserirDTO dto);

    List<Endereco> getAll();

    Optional<Endereco> get(Integer id);

    void update(Endereco endereco);

    void delete(Endereco endereco);

}
