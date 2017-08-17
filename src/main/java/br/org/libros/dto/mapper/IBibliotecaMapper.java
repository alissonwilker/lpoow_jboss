package br.org.libros.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.org.libros.dto.BibliotecaDto;
import br.org.libros.model.persistence.entity.Biblioteca;

@Mapper
public interface IBibliotecaMapper extends IGenericMapper<Biblioteca, BibliotecaDto> {
	IBibliotecaMapper INSTANCE = Mappers.getMapper(IBibliotecaMapper.class);

}
