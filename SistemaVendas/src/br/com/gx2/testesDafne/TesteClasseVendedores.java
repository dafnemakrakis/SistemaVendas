package br.com.gx2.testesDafne;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.gx2.entity.Vendedor;
import br.com.gx2.service.ServiceFactory;
import br.com.gx2.service.VendedorService;



public class TesteClasseVendedores {
	
		
		//Montagem cenário
		VendedorService vendedorService = ServiceFactory.createVendedorService();
	
		
		Vendedor vendedor01 = new Vendedor (null, "0521", "Neiva");   
		Vendedor vendedor02 = new Vendedor (null, "6588", "Antonio");
		
				
		@Test
		public void CadastraVendedor() {
			
			//Execução		
			boolean retorno1 = vendedorService.cadastrarVendedor(vendedor01);
			boolean retorno2 = vendedorService.cadastrarVendedor(vendedor02);
			
			//Verificação
			assertTrue(retorno1);
			assertTrue(retorno2);
					
					
		}
		
		@Test
		public void CadastraVendedorMatriculaBranco() {
			
			Vendedor vendedor = new Vendedor (null, "", "Neiva");
			
			//Execução		
			boolean retorno1 = vendedorService.cadastrarVendedor(vendedor);
			
			
			//Verificação
			assertTrue(retorno1);
							
					
		}
		
		@Test
		public void CadastraVendedorNomeBranco() {
			
			Vendedor vendedor = new Vendedor (null, "1654", "");
			
			//Execução		
			boolean retorno1 = vendedorService.cadastrarVendedor(vendedor);
			
			
			//Verificação
			assertTrue(retorno1);
							
					
		}
		
		@Test
		public void AlteraVendedor() {
			
			//Execução
			Vendedor vendedor01 = new Vendedor (6, "1003", "Bernardo");;
			boolean retorno = vendedorService.alterarVendedor(vendedor01);
			
			//Verificação
			assertTrue(retorno);
					
					
		}
		
		@Test
		public void ApagaVendedor() {
			
			//Execução		
			boolean retorno = vendedorService.apagarVendedor(5);
			
			
			//Verificação
			assertTrue(retorno);
			
			/*assertThat(retorno, is(true));
			assertThat(grupoService.size(), is(1));
			assertNull(grupoService.pesquisaCliente(2));*/
					
					
		}
		
		@Test
		public void PesquisaVendedor() {
			
			
			//Execução		
			Vendedor vendedor = vendedorService.pesquisarVendedorId(1);
			
			
			//Verificação
			assertThat(vendedor.getCodigoVendedor(), is(1));
					
					
		}
		
		@Test
		public void PesquisaTodosVendedores() {
			
			//Execução	
		
			vendedorService.exibirTodosVendedores();
					
			
			//Verificação
			assertThat(vendedorService.exibirTodosVendedores().size(), is (10));
					
					
		}
		
	

}
