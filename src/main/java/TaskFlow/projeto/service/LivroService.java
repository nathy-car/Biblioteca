package TaskFlow.projeto.service;

import TaskFlow.projeto.exception.LivroNotFoundException;
import TaskFlow.projeto.mapper.LivroMapper;
import TaskFlow.projeto.model.Livro;
import TaskFlow.projeto.model.LivroDTO;
import TaskFlow.projeto.repositories.LivrosRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    private final LivrosRepository livrosRepository;

    public LivroService(LivrosRepository livrosRepository){
        this.livrosRepository = livrosRepository;
    }

    public List<Livro> getLivros(){
        return livrosRepository.findAll();
    }

    public Livro postLivros(LivroDTO livroDTO){
        Livro livro = LivroMapper.INSTANCE.criarLivro(livroDTO);
        return livrosRepository.save(livro);
    }

    public Livro patchLivro(Long id, LivroDTO livroDTO){
        Livro livro = livrosRepository.findById(id).orElseThrow(() -> new LivroNotFoundException(id));
        LivroMapper.INSTANCE.atualizarLivro(livroDTO, livro);
        return livrosRepository.save(livro);
    }

    public void deleteLivro(Long id){
        Livro livro = livrosRepository.findById(id).orElseThrow(() -> new LivroNotFoundException(id));
        livrosRepository.deleteById(id);
    }

    public Livro getLivroPorId(Long id){
        return livrosRepository.findById(id).orElseThrow(() -> new LivroNotFoundException(id));
    }
}
