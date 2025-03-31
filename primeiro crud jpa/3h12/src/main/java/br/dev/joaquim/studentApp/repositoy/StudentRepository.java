package br.dev.joaquim.studentApp.repositoy;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.dev.joaquim.studentApp.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    public List<Student> findByNome(String nome);
    public List<Student> findByNomeStartingWith(String nome);
}