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

    public List<Ramal> buscar(String termo) {

        Sort ordenacao = Sort.by("setor").ascending()
                .and(Sort.by("nome").ascending());

        if (termo == null || termo.isBlank()) {
            return listarTodos();
        }

        // Se for número → buscar por ramal
        if (termo.matches("\\d+")) {
            return repository.findByRamal(
                    Integer.valueOf(termo),
                    ordenacao
            );
        }

        // Se for texto → buscar por setor ou nome
        return repository.findBySetorContainingIgnoreCaseOrNomeContainingIgnoreCase(
                termo,
                termo,
                ordenacao
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
