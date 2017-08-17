package br.org.libros.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.org.libros.dto.ClienteDto;
import br.org.libros.model.persistence.entity.Cliente;

@Mapper
public interface IClienteMapper extends IGenericMapper<Cliente, ClienteDto> {
	IClienteMapper INSTANCE = Mappers.getMapper(IClienteMapper.class);

}
