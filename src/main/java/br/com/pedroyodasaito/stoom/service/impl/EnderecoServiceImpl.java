package br.com.pedroyodasaito.stoom.service.impl;

import br.com.pedroyodasaito.stoom.api.v1.EnderecoInserirDTO;
import br.com.pedroyodasaito.stoom.entity.Endereco;
import br.com.pedroyodasaito.stoom.repository.EnderecoRepository;
import br.com.pedroyodasaito.stoom.service.EnderecoService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    private final EnderecoRepository repository;

    public EnderecoServiceImpl(EnderecoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Endereco insert(EnderecoInserirDTO dto) {
        return repository.save(dtoToEntity(dto));
    }

    @Override
    public List<Endereco> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Endereco> get(Integer id) {
        return repository.findById(id);
    }

    @Override
    public void update(Endereco endereco) {
        repository.save(endereco);
    }

    @Override
    public void delete(Endereco endereco) {
        repository.delete(endereco);
    }

    private Endereco dtoToEntity(EnderecoInserirDTO dto) {
        Endereco endereco = new Endereco();
        endereco.setCity(dto.getCity());
        endereco.setComplement(dto.getComplement());
        endereco.setCountry(dto.getCountry());
        endereco.setLatitude(dto.getLatitude());
        endereco.setLongitude(dto.getLongitude());
        endereco.setNeighbourhood(dto.getNeighbourhood());
        endereco.setNumber(dto.getNumber());
        endereco.setZipcode(dto.getZipcode());
        endereco.setStreetName(dto.getStreetName());
        return endereco;
    }
}
