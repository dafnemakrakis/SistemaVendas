package br.com.gx2.testesDafne;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.gx2.dao.DAOFactory;
import br.com.gx2.dao.VendedorDAO;
import br.com.gx2.entity.Grupo;
import br.com.gx2.entity.Loja;
import br.com.gx2.entity.Vendedor;
import br.com.gx2.service.LojaService;
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
		public void CadastraGrupoBranco() {
			
			Grupo grupo03 = new Grupo (null, "");
			
			//Execução		
			boolean retorno1 = grupoService.cadastrarGrupo(grupo03);
			
			
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
			List<Vendedor> vendedores = new ArrayList<Vendedor>();
			boolean retorno = vendedorService.exibirTodosVendedores(vendedores);
					
			
			//Verificação
			assertTrue(retorno);
					
					
		}
		
	

}
