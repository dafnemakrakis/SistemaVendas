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
			
		//Montagem cenário
		private GrupoService grupoService = ServiceFactory.createGrupoService();
				
				
		private Grupo grupo01 = new Grupo (null, "Feminino");   
		private Grupo grupo02 = new Grupo (null, "Masculino");
			
	
	
	@Test
	public void CadastraGrupo() {
		
		//Execução		
		boolean retorno1 = grupoService.cadastrarGrupo(grupo01);
		boolean retorno2 = grupoService.cadastrarGrupo(grupo02);
		
		//Verificação
		assertTrue(retorno1);
		assertTrue(retorno2);
				
				
	}
	
	@Test
	public void CadastraGrupoBranco() {
		
		Grupo grupo03 = new Grupo (null, "");
		
		//Execução		
		boolean retorno1 = grupoService.cadastrarGrupo(grupo03);
		
		
		//Verificação
		assertTrue(retorno1);
						
				
	}
	
	@Test
	public void AlteraGrupo() {
		
		//Execução
		Grupo grupo01 = new Grupo (1, "Unissex");
		boolean retorno = grupoService.alterarGrupo(grupo01);
		
		//Verificação
		assertTrue(retorno);
				
				
	}
	
	@Test
	public void ApagaGrupo() {
		
		//Execução		
		boolean retorno = grupoService.apagarGrupo(11);
		
		
		//Verificação
		assertTrue(retorno);
		
		/*assertThat(retorno, is(true));
		assertThat(grupoService.size(), is(1));
		assertNull(grupoService.pesquisaCliente(2));*/
				
				
	}
	
	@Test
	public void PesquisaGrupo() {
		
		//Execução		
		Grupo grupo = grupoService.pesquisarGrupoId(1);
		
		
		
		//Verificação
		assertThat(grupo.getCodigoGrupo(), is(1));
				
				
	}
	

	@Test
	public void PesquisaTodosGrupos() {
		
		//Execução	
		List<Grupo> grupos = new ArrayList<Grupo>();
		boolean retorno = grupoService.exibirTodosGrupos(grupos);
				
		
		//Verificação
		assertTrue(retorno);
				
				
	}
	
	
	
	
	
	

}
