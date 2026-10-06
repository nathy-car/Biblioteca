package TaskFlow.projeto.controller;

import TaskFlow.projeto.model.Livro;
import TaskFlow.projeto.model.LivroDTO;
import TaskFlow.projeto.service.LivroService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("livros")
public class HomeController {

    private final LivroService livroService;

    public HomeController(LivroService livroService) {
        this.livroService = livroService;
    }

    @GetMapping("")
    public ResponseEntity<List<Livro>> getLivros() {
        return ResponseEntity.ok(livroService.getLivros());
    }

    @PostMapping("")
    public ResponseEntity<Livro> postLivro(@Valid  @RequestBody LivroDTO livro) {
        return ResponseEntity.created(null).
                body(livroService.postLivros(livro));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Livro> patchLivro(@PathVariable Long id, @RequestBody LivroDTO livroDTO) {
        return ResponseEntity.ok(livroService.patchLivro(id, livroDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteLivro(@PathVariable Long id){
        livroService.deleteLivro(id);
       return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> getLivroPorId(@PathVariable Long id){
        Livro livro = livroService.getLivroPorId(id);
        return ResponseEntity.ok().body(livro);
    }
}
