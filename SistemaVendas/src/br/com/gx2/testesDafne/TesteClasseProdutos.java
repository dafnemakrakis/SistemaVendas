package br.com.gx2.testesDafne;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.gx2.entity.Grupo;
import br.com.gx2.entity.Produto;
import br.com.gx2.service.GrupoService;
import br.com.gx2.service.ProdutoService;
import br.com.gx2.service.ServiceFactory;



public class TesteClasseProdutos {
	
		
		//Montagem cen�rio
		
		ProdutoService produtoService = ServiceFactory.createProdutoService();
		
		Grupo grupo01 = new Grupo (1, "Feminino");   
		Grupo grupo02 = new Grupo (2, "Masculino");
		
		
		Produto produto01 = new Produto (null, "684615", "camiseta", grupo02);   
		Produto produto02 = new Produto (null, "484325", "saia", grupo01);
		
		
		@Test
		public void CadastraProduto() {
			
			//Execu��o		
			boolean retorno1 = produtoService.cadastrarProduto(produto01);
			boolean retorno2 = produtoService.cadastrarProduto(produto02);
			
			//Verifica��o
			assertTrue(retorno1);
			assertTrue(retorno2);
					
					
		}
		
		@Test
		public void CadastraProdutoNcmBranco() {
			
			Produto produto = new Produto (null, "", "camiseta", grupo02);;
			
			//Execu��o		
			boolean retorno1 = produtoService.cadastrarProduto(produto);
			
			
			//Verifica��o
			assertTrue(retorno1);
							
					
		}
		
		@Test
		public void CadastraProdutoNomeBranco() {
			
			Produto produto = new Produto (null, "61351", "", grupo02);;
			
			//Execu��o		
			boolean retorno1 = produtoService.cadastrarProduto(produto);
			
			
			//Verifica��o
			assertTrue(retorno1);
							
					
		}
		
		@Test
		public void AlteraProduto() {
			
			//Execu��o
			Produto produto = new Produto (4, "4648788725", "anel", grupo01);
			boolean retorno = produtoService.alterarProduto(produto);
			
			//Verifica��o
			assertTrue(retorno);
					
					
		}
		
		@Test
		public void ApagaProduto() {
			
			//Execu��o		
			boolean retorno = produtoService.apagarProduto(12);
			
			
			//Verifica��o
			assertTrue(retorno);
			
			/*assertThat(retorno, is(true));
			assertThat(grupoService.size(), is(1));
			assertNull(grupoService.pesquisaCliente(2));*/
					
					
		}
		
		@Test
		public void PesquisaProduto() {
			
			
			
			//Execu��o		
			 Produto produto = produtoService.pesquisarProdutoId(1);
			
			
			//Verifica��o
			assertThat(produto.getCodigoProduto(), is(1));
					
					
		}
		
		@Test
		public void PesquisaTodosProdutos() {
			
			//Execu��o	
			produtoService.exibirTodosProdutos();
					
			
			//Verifica��o
			assertThat(produtoService.exibirTodosProdutos().size(), is (17));
					
					
		}
		

}
