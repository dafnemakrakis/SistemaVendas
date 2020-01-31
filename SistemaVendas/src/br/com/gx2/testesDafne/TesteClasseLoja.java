package br.com.gx2.testesDafne;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.gx2.dao.DAOFactory;
import br.com.gx2.dao.LojaDAO;
import br.com.gx2.entity.Grupo;
import br.com.gx2.entity.Loja;
import br.com.gx2.service.LojaService;
import br.com.gx2.service.ServiceFactory;
import br.com.gx2.service.imp.LojaServiceImp;


public class TesteClasseLoja {
	
			
		//Montagem cenário
		LojaService lojaService = ServiceFactory.createLojaService();
		
		
		Loja loja02 = new Loja (null, "Partenon");
		Loja loja03 = new Loja (null, "Centro");

		
		@Test
		public void CadastraLoja() {
			
			//Execução		
			boolean retorno1 = lojaService.cadastrarLoja(loja02);
			boolean retorno2 = lojaService.cadastrarLoja(loja03);
			
			//Verificação
			assertTrue(retorno1);
			assertTrue(retorno2);
					
					
		}
		
		@Test
		public void CadastraLojaBranco() {
			
			Loja loja = new Loja (null, "");
			
			//Execução		
			boolean retorno1 = lojaService.cadastrarLoja(loja);
			
			
			//Verificação
			assertTrue(retorno1);
							
					
		}
		
		@Test
		public void AlteraLoja() {
			
			//Execução
			Loja loja03 = new Loja (5, "Partenon");
			boolean retorno = lojaService.alterarLoja(loja03);
			
			//Verificação
			assertTrue(retorno);
					
					
		}
		
		@Test
		public void ApagaLoja() {
			
			//Execução		
			boolean retorno = lojaService.apagarLoja(12);
			
			
			//Verificação
			assertTrue(retorno);
			
			/*assertThat(retorno, is(true));
			assertThat(grupoService.size(), is(1));
			assertNull(grupoService.pesquisaCliente(2));*/
					
					
		}
		
		@Test
		public void PesquisaLoja() {
			
			
			//Execução		
		Loja loja = lojaService.pesquisarLojaId(4);
			
			
			//Verificação
			assertThat(loja.getCodigoLoja(), is(4));
			System.out.println(loja);
					
					
		}
		
		@Test
		public void PesquisaTodasLojas() {
			
			//Execução	
			List<Loja> lojas = new ArrayList<Loja>();
			boolean retorno = LojaService.exibirTodasLojas(lojas);
					
			
			//Verificação
			assertTrue(retorno);
					
					
		}
		
		
	

}
