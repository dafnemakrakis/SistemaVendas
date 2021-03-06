package br.com.gx2.testesDafne;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.gx2.entity.Loja;
import br.com.gx2.service.LojaService;
import br.com.gx2.service.ServiceFactory;
import br.com.gx2.service.imp.LojaServiceImp;


public class TesteClasseLoja {
	
			
		//Montagem cen�rio
		LojaService lojaService = ServiceFactory.createLojaService();
		
		String nome1 = "Partenon";
		String nome2 = "Centro";
		
		Loja loja02 = new Loja (null, nome1);
		Loja loja03 = new Loja (null, nome2);

		
		@Test
		public void CadastraLoja() {
			
			//Execu��o		
			boolean retorno1 = lojaService.cadastrarLoja(loja02);
			boolean retorno2 = lojaService.cadastrarLoja(loja03);
			
			//Verifica��o
			assertTrue(retorno1);
			assertTrue(retorno2);
					
					
		}
		
		@Test
		public void CadastraLojaBranco() {
			
			Loja loja = new Loja (null, "");
			
			//Execu��o		
			boolean retorno1 = lojaService.cadastrarLoja(loja);
			
			
			//Verifica��o
			assertTrue(retorno1);
							
					
		}
		
		@Test
		public void AlteraLoja() {
			
			//Execu��o
			Loja loja03 = new Loja (5, "Partenon");
			boolean retorno = lojaService.alterarLoja(loja03);
			
			//Verifica��o
			assertTrue(retorno);
					
					
		}
		
		@Test
		public void ApagaLoja() {
			
			//Execu��o		
			boolean retorno = lojaService.apagarLoja(12);
			
			
			//Verifica��o
			assertTrue(retorno);
			
			/*assertThat(retorno, is(true));
			assertThat(grupoService.size(), is(1));
			assertNull(grupoService.pesquisaCliente(2));*/
					
					
		}
		
		@Test
		public void PesquisaLoja() {
			
			
			//Execu��o		
		Loja loja = lojaService.pesquisarLojaId(4);
			
			
			//Verifica��o
			assertThat(loja.getCodigoLoja(), is(4));
			System.out.println(loja);
					
					
		}
		
		@Test
		public void PesquisaTodasLojas() {
			
			//Execu��o	
			lojaService.exibirTodasLojas();
					
			
			//Verifica��o
			assertThat(lojaService.exibirTodasLojas().size(), is (15));
					
					
		}
		
		
	

}
