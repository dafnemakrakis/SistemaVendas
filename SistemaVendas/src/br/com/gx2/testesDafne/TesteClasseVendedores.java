package br.com.gx2.testesDafne;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.gx2.entity.Vendedor;
import br.com.gx2.service.ServiceFactory;
import br.com.gx2.service.VendedorService;



public class TesteClasseVendedores {
	
		
		//Montagem cen�rio
		VendedorService vendedorService = ServiceFactory.createVendedorService();
	
		
		Vendedor vendedor01 = new Vendedor (null, "0521", "Neiva");   
		Vendedor vendedor02 = new Vendedor (null, "6588", "Antonio");
		
				
		@Test
		public void CadastraVendedor() {
			
			//Execu��o		
			boolean retorno1 = vendedorService.cadastrarVendedor(vendedor01);
			boolean retorno2 = vendedorService.cadastrarVendedor(vendedor02);
			
			//Verifica��o
			assertTrue(retorno1);
			assertTrue(retorno2);
					
					
		}
		
		@Test
		public void CadastraVendedorMatriculaBranco() {
			
			Vendedor vendedor = new Vendedor (null, "", "Neiva");
			
			//Execu��o		
			boolean retorno1 = vendedorService.cadastrarVendedor(vendedor);
			
			
			//Verifica��o
			assertTrue(retorno1);
							
					
		}
		
		@Test
		public void CadastraVendedorNomeBranco() {
			
			Vendedor vendedor = new Vendedor (null, "1654", "");
			
			//Execu��o		
			boolean retorno1 = vendedorService.cadastrarVendedor(vendedor);
			
			
			//Verifica��o
			assertTrue(retorno1);
							
					
		}
		
		@Test
		public void AlteraVendedor() {
			
			//Execu��o
			Vendedor vendedor01 = new Vendedor (6, "1003", "Bernardo");;
			boolean retorno = vendedorService.alterarVendedor(vendedor01);
			
			//Verifica��o
			assertTrue(retorno);
					
					
		}
		
		@Test
		public void ApagaVendedor() {
			
			//Execu��o		
			boolean retorno = vendedorService.apagarVendedor(5);
			
			
			//Verifica��o
			assertTrue(retorno);
			
			/*assertThat(retorno, is(true));
			assertThat(grupoService.size(), is(1));
			assertNull(grupoService.pesquisaCliente(2));*/
					
					
		}
		
		@Test
		public void PesquisaVendedor() {
			
			
			//Execu��o		
			Vendedor vendedor = vendedorService.pesquisarVendedorId(1);
			
			
			//Verifica��o
			assertThat(vendedor.getCodigoVendedor(), is(1));
					
					
		}
		
		@Test
		public void PesquisaTodosVendedores() {
			
			//Execu��o	
		
			vendedorService.exibirTodosVendedores();
					
			
			//Verifica��o
			assertThat(vendedorService.exibirTodosVendedores().size(), is (10));
					
					
		}
		
	

}
