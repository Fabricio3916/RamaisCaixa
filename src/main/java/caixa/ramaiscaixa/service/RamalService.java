package caixa.ramaiscaixa.service;

import caixa.ramaiscaixa.model.Ramal;
import caixa.ramaiscaixa.repository.RamalRepository;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Sort;

import java.util.List;

@Service
public class RamalService {

    private final RamalRepository repository;

    public RamalService(RamalRepository repository) {
        this.repository = repository;
    }

    public List<Ramal> listarTodos() {
        return repository.findAll(
                Sort.by("setor").ascending()
                        .and(Sort.by("nome").ascending())
        );
    }

    public Ramal salvar(Ramal ramal) {
        return repository.save(ramal);
    }

    public Ramal buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Ramal não encontrado"));
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }
}
