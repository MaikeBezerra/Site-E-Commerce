package br.ufc.web.service;

import java.util.List;

public interface GenericService<T> {

	public List<T> listar();
	public T buscar(Long id);
	public void remover(Long id);
}
