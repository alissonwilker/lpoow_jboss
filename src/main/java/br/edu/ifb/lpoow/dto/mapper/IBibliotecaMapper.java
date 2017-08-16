package br.edu.ifb.lpoow.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.edu.ifb.lpoow.dto.BibliotecaDto;
import br.edu.ifb.lpoow.model.persistence.entity.Biblioteca;

@Mapper
public interface IBibliotecaMapper extends IGenericMapper<Biblioteca, BibliotecaDto> {
	IBibliotecaMapper INSTANCE = Mappers.getMapper(IBibliotecaMapper.class);

}
