package br.com.gx2.testesDafne;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import br.com.gx2.entity.Grupo;
import br.com.gx2.service.GrupoService;
import br.com.gx2.service.ServiceFactory;



public class TesteClasseGrupo {
			
		//Montagem cenário
		private GrupoService grupoService = ServiceFactory.createGrupoService();
			
		String nome1 = "Feminino";
		String nome2 = "Masculino";
				
		private Grupo grupo01 = new Grupo (null, nome1);   
		private Grupo grupo02 = new Grupo (null, nome2);
			
	
	
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
		boolean retorno = grupoService.apagarGrupo(17);
				
		
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
		
		grupoService.exibirTodosGrupos();
				
		
		//Verificação
		assertThat(grupoService.exibirTodosGrupos().size(), is (26));
				
				
	}
	
	
	
	
	
	

}
