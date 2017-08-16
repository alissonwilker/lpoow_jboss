package br.edu.ifb.lpoow.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.edu.ifb.lpoow.dto.LivroDto;
import br.edu.ifb.lpoow.model.persistence.entity.Livro;

@Mapper
public interface ILivroMapper extends IGenericMapper<Livro, LivroDto> {
	ILivroMapper INSTANCE = Mappers.getMapper(ILivroMapper.class);

}
