package br.gov.incra.sagra.persistencia;

public interface Persistencia<T> {

	public RespostaPersistenciaEntidade<T> cadastrar(T entidade);
	
	public RespostaPersistenciaColecao<T> listar();

}
