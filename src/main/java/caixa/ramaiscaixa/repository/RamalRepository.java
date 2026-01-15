package caixa.ramaiscaixa.repository;

import caixa.ramaiscaixa.model.Ramal;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RamalRepository extends JpaRepository<Ramal, Long> {

    List<Ramal> findBySetorContainingIgnoreCaseOrNomeContainingIgnoreCase(
            String setor,
            String nome,
            Sort sort
    );

    List<Ramal> findByRamal(
            Integer ramal,
            Sort sort
    );
}
