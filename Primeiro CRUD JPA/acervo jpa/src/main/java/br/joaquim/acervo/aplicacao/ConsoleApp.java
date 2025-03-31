package br.joaquim.acervo.aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.joaquim.acervo.entidade.Biblioteca;
import br.joaquim.acervo.entidade.Livro;
import br.joaquim.acervo.repositorio.BibliotecaRepository;
import br.joaquim.acervo.repositorio.LivroRepository;
import jakarta.transaction.Transactional;

@Component
public class ConsoleApp {

    @Autowired
	private LivroRepository livroRepository;

    @Autowired
    private BibliotecaRepository biblRepository;

    public void iniciar() {
        System.out.println("Olá mundo");

        Biblioteca b = new Biblioteca(2, "Alexandria", new ArrayList<>());

        /*
         * select * from biblioteca b1_0 left join livros l1_0 on b1_0.id=l1_0.biblioteca_id where b1_0.id=?
         * 
         * se nao existir
         * insert into biblioteca (nome,id) values (?,?)
         * 
         * se ja existir
         * update biblioteca set nome=? where id=?
         */
        // biblRepository.save(b);

        Livro l1 = new Livro(3, "Storytelling com Dados", "Cole Nussbaumer Knaflic", 2018, "Alta Books", b);
        Livro l2 = new Livro(4, "Avalie o que Importa: Como o Google, Bono Vox e a Fundação Gates Sacudiram o Mundo com os OKRs", "John Doerr", 2019, "Alta Books", b);

        /*
         * select * from livros l1_0 where l1_0.id=?
         * 
         * se nao existir
         * insert into livros (ano_publicacao,autor,biblioteca_id,editora,titulo,id) values (?,?,?,?,?,?)
         * 
         * se ja existir
         * update livros set ano_publicacao=?,autor=?,biblioteca_id=?,editora=?,titulo=? where id=?
         */
        livroRepository.save(l1);
        livroRepository.save(l2);


        /*
         * select * from biblioteca b1_0
         * 
         * para cada biblioteca executa:
         * select * from livros l1_0 where l1_0.biblioteca_id=?
         */
        List<Biblioteca> resposta = biblRepository.findAll();
        
		System.out.println("======= Bibliotecas =======");
		for(Biblioteca biblioteca: resposta) {
            System.out.println("///// " + biblioteca.getNome() + " //////");
            List<Livro> livros = biblioteca.getLivros();
            for(Livro livro: livros) {
                System.out.println(livro);
            }
            System.err.println("////////////////////////////////");
        }
		System.out.println("===========================");
    }
}
