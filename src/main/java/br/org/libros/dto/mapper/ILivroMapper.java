package br.org.libros.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.org.libros.dto.LivroDto;
import br.org.libros.model.persistence.entity.Livro;

@Mapper
public interface ILivroMapper extends IGenericMapper<Livro, LivroDto> {
	ILivroMapper INSTANCE = Mappers.getMapper(ILivroMapper.class);

}
