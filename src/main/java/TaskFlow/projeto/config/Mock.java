package TaskFlow.projeto.config;

import TaskFlow.projeto.model.Livro;
import TaskFlow.projeto.repositories.LivrosRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class Mock implements CommandLineRunner {

    private final LivrosRepository livrosRepository;

    public Mock(LivrosRepository livrosRepository){
        this.livrosRepository = livrosRepository;
    }


    @Override
    public void run(String... args) throws Exception {
            List<Livro> livros = new ArrayList<>();

            livros.add(new Livro(null, "Clean Code", "Robert C. Martin", "2008"));
            livros.add(new Livro(null, "Design Patterns", "Gang of Four", "1994"));
            livros.add(new Livro(null, "The Pragmatic Programmer", "Andrew Hunt e David Thomas", "1999"));
            livros.add(new Livro(null, "Refactoring", "Martin Fowler", "1999"));
            livros.add(new Livro(null, "Java Concurrency in Practice", "Brian Goetz", "2006"));

            livrosRepository.saveAll(livros);
        }
        }



