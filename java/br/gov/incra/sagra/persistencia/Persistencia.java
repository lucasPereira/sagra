package br.gov.incra.sagra.persistencia;

public interface Persistencia<T> {

	public RespostaPersistencia<T> cadastrar(T entidade);

}
