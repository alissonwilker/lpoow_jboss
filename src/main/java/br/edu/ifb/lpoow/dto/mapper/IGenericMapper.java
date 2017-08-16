package br.edu.ifb.lpoow.dto.mapper;

import java.util.List;

public interface IGenericMapper<E, D> {
	D converterParaDto(E biblioteca);

	E converterParaEntidade(D dto);

	List<D> converterParaDto(List<E> biblioteca);

	List<E> converterParaEntidade(List<D> dto);
}
