package br.org.libros.dto.mapper;

import java.util.List;

public interface IGenericMapper<E, D> {
	D converterParaDto(E entidade);

	E converterParaEntidade(D dto);

	List<D> converterParaDto(List<E> entidade);

	List<E> converterParaEntidade(List<D> dto);
}
