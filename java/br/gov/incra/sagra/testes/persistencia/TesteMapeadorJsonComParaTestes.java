package br.gov.incra.sagra.testes.persistencia;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import br.gov.incra.sagra.auxiliar.Entidade;
import br.gov.incra.sagra.infraestrutura.Ambiente;
import br.gov.incra.sagra.persistencia.Documento;
import br.gov.incra.sagra.persistencia.MapeadorJsonParaTestes;
import br.gov.incra.sagra.testes.infraestrutura.TesteAmbiente;
import br.ufsc.ine.leb.projetos.estoria.Fixture;
import br.ufsc.ine.leb.projetos.estoria.FixtureSetup;

@FixtureSetup({ TesteAmbiente.class, TesteDocumento.class })
public class TesteMapeadorJsonComParaTestes {

	@Fixture private Ambiente ambiente;
	@Fixture private Entidade entidade1;
	@Fixture private Documento<Entidade> documentoEntidade1;

	private String jsonEntidade1;
	private String jsonDocumentoEntidade1;

	private MapeadorJsonParaTestes mapeadorJsonPadrao;

	@Before
	public void configurar() {
		jsonEntidade1 = "{\"nome\":\"Entidade 1\",\"_id\":\"1\"}";
		jsonDocumentoEntidade1 = "{\"nome\":\"Entidade 1\",\"_id\":\"1\"}";
		mapeadorJsonPadrao = new MapeadorJsonParaTestes(ambiente);
	}

	@Test
	public void paraJson() throws Exception {
		assertEquals(jsonEntidade1, mapeadorJsonPadrao.mapearEntidadeParaJson(entidade1));
		assertEquals(jsonDocumentoEntidade1, mapeadorJsonPadrao.mapearDocumentoParaJson(documentoEntidade1));
	}

	@Test
	public void paraObjeto() throws Exception {
		assertEquals(entidade1, mapeadorJsonPadrao.mapearJsonParaEntidade(jsonEntidade1));
		assertEquals(documentoEntidade1, mapeadorJsonPadrao.mapearJsonParaDocumento(jsonDocumentoEntidade1));
	}

}
