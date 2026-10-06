package TaskFlow.projeto.mapper;

import TaskFlow.projeto.model.Livro;
import TaskFlow.projeto.model.LivroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface LivroMapper {

    LivroMapper INSTANCE = Mappers.getMapper(LivroMapper.class);

    void atualizarLivro(LivroDTO dto, @MappingTarget Livro livro);
    Livro criarLivro(LivroDTO dto);

}
