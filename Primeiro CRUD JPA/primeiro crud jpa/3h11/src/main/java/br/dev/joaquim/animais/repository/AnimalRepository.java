package br.dev.joaquim.animais.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import br.dev.joaquim.animais.entities.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Long> {
    public List<Animal> findByNomeContainingIgnoreCase(String nome);
}
