package br.com.pedroyodasaito.stoom.api.v1;

import br.com.pedroyodasaito.stoom.entity.Endereco;
import br.com.pedroyodasaito.stoom.service.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequestMapping("/v1/endereco")
public class EnderecoController {

    private final EnderecoService service;

    public EnderecoController(EnderecoService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public Integer salvar(@RequestBody @Valid EnderecoInserirDTO dto){
        return service.insert(dto).getId();
    }

    @GetMapping
    public List<Endereco> getAll(){
        return service.getAll();
    }

    @GetMapping("{id}")
    public Endereco getById(@PathVariable Integer id){
        return service
                .get(id)
                .orElseThrow(() ->
                        new ResponseStatusException(NOT_FOUND, "Endereço não encontrado."));
    }

    @PutMapping
    @ResponseStatus(NO_CONTENT)
    public void update(@RequestBody Endereco endereco){
        Endereco enderecoBD = service.get(endereco.getId())
                .map(e -> {
                    e.setStreetName(endereco.getStreetName());
                    e.setZipcode(endereco.getZipcode());
                    e.setNumber(endereco.getNumber());
                    e.setNeighbourhood(endereco.getNeighbourhood());
                    e.setLongitude(endereco.getLongitude());
                    e.setLatitude(endereco.getLatitude());
                    e.setCountry(endereco.getCountry());
                    e.setComplement(endereco.getComplement());
                    e.setCity(endereco.getCity());
                    return e;
                })
                .orElseThrow(() ->
                        new ResponseStatusException(NOT_FOUND, "Endereço não encontrado."));

        service.update(enderecoBD);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Integer id){
        service.delete(service.get(id)
                .orElseThrow(() ->
                        new ResponseStatusException(NOT_FOUND, "Endereço não encontrado.")));
    }
}
