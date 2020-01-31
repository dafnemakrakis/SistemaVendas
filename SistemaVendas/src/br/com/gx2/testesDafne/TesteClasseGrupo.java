package br.com.gx2.testesDafne;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.gx2.dao.DAOFactory;
import br.com.gx2.dao.GrupoDAO;
import br.com.gx2.entity.Grupo;
import br.com.gx2.service.GrupoService;
import br.com.gx2.service.ServiceFactory;



public class TesteClasseGrupo {
			
		//Montagem cen�rio
		private GrupoService grupoService = ServiceFactory.createGrupoService();
				
				
		private Grupo grupo01 = new Grupo (null, "Feminino");   
		private Grupo grupo02 = new Grupo (null, "Masculino");
			
	
	
	@Test
	public void CadastraGrupo() {
		
		//Execu��o		
		boolean retorno1 = grupoService.cadastrarGrupo(grupo01);
		boolean retorno2 = grupoService.cadastrarGrupo(grupo02);
		
		//Verifica��o
		assertTrue(retorno1);
		assertTrue(retorno2);
				
				
	}
	
	@Test
	public void CadastraGrupoBranco() {
		
		Grupo grupo03 = new Grupo (null, "");
		
		//Execu��o		
		boolean retorno1 = grupoService.cadastrarGrupo(grupo03);
		
		
		//Verifica��o
		assertTrue(retorno1);
						
				
	}
	
	@Test
	public void AlteraGrupo() {
		
		//Execu��o
		Grupo grupo01 = new Grupo (1, "Unissex");
		boolean retorno = grupoService.alterarGrupo(grupo01);
		
		//Verifica��o
		assertTrue(retorno);
				
				
	}
	
	@Test
	public void ApagaGrupo() {
		
		//Execu��o		
		boolean retorno = grupoService.apagarGrupo(11);
		
		
		//Verifica��o
		assertTrue(retorno);
		
		/*assertThat(retorno, is(true));
		assertThat(grupoService.size(), is(1));
		assertNull(grupoService.pesquisaCliente(2));*/
				
				
	}
	
	@Test
	public void PesquisaGrupo() {
		
		//Execu��o		
		Grupo grupo = grupoService.pesquisarGrupoId(1);
		
		
		
		//Verifica��o
		assertThat(grupo.getCodigoGrupo(), is(1));
				
				
	}
	

	@Test
	public void PesquisaTodosGrupos() {
		
		//Execu��o	
		List<Grupo> grupos = new ArrayList<Grupo>();
		boolean retorno = grupoService.exibirTodosGrupos(grupos);
				
		
		//Verifica��o
		assertTrue(retorno);
				
				
	}
	
	
	
	
	
	

}
