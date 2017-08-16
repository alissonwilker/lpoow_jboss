package br.edu.ifb.lpoow.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import br.edu.ifb.lpoow.dto.ClienteDto;
import br.edu.ifb.lpoow.model.persistence.entity.Cliente;

@Mapper
public interface IClienteMapper extends IGenericMapper<Cliente, ClienteDto> {
	IClienteMapper INSTANCE = Mappers.getMapper(IClienteMapper.class);

}
