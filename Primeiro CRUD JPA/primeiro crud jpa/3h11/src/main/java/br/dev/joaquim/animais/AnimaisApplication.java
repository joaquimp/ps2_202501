package br.dev.joaquim.animais;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.dev.joaquim.animais.entities.Animal;
import br.dev.joaquim.animais.repository.AnimalRepository;

@SpringBootApplication
public class AnimaisApplication implements CommandLineRunner {

	@Autowired
	private AnimalRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(AnimaisApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Olá mundo");

		// System.out.print("Informe o nome do animal: ");
		// String nome = System.console().readLine();
		// System.out.print("Informe o registro do animal: ");
		// long registro = Long.parseLong(System.console().readLine());

		// Animal a = new Animal(nome, registro);
		// repository.save(a);

		List<Animal> animais = repository.findByNomeContainingIgnoreCase("I");
		
		for(Animal animal : animais) {
			System.out.println(animal);
		}
	}

}
