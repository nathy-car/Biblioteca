package TaskFlow.projeto.exception;

import TaskFlow.projeto.model.Livro;

public class LivroNotFoundException extends RuntimeException{

    public LivroNotFoundException(Long id){
        super("Livro não encontrado: " + id);
    }

}
