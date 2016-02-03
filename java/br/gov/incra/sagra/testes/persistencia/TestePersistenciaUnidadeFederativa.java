package br.gov.incra.sagra.testes.persistencia;

import static org.junit.Assert.*;

import org.junit.Test;

import br.gov.incra.sagra.entidades.UnidadeFederativa;
import br.gov.incra.sagra.persistencia.PersistenciaUnidadeFederativa;
import br.gov.incra.sagra.testes.entidades.TesteSantaCatarina;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup(TesteSantaCatarina.class)
public class TestePersistenciaUnidadeFederativa {

	@Fixture private UnidadeFederativa santaCatarina;

	@Test
	public void cadastrarSantaCatarina() throws Exception {
		PersistenciaUnidadeFederativa persistencia = new PersistenciaUnidadeFederativa();
		assertTrue(persistencia.cadastrarUnidadeFederativa(santaCatarina));
	}

	@Test
	public void cadastrarSantaCatarinaDuasVezes() throws Exception {
		PersistenciaUnidadeFederativa persistencia = new PersistenciaUnidadeFederativa();
		assertTrue(persistencia.cadastrarUnidadeFederativa(santaCatarina));
		assertFalse(persistencia.cadastrarUnidadeFederativa(santaCatarina));
	}

}