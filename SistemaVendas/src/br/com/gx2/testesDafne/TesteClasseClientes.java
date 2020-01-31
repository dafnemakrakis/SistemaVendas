package br.com.gx2.testesDafne;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.gx2.dao.ClienteDAO;
import br.com.gx2.dao.DAOFactory;
import br.com.gx2.entity.Cliente;
import br.com.gx2.entity.Grupo;
import br.com.gx2.entity.Loja;
import br.com.gx2.service.ClienteService;
import br.com.gx2.service.GrupoService;
import br.com.gx2.service.LojaService;
import br.com.gx2.service.ServiceFactory;



public class TesteClasseClientes {
			
		//Montagem cen�rio
		ClienteService clienteService = ServiceFactory.createClienteService();
		
	
		
		Cliente cliente01 = new Cliente (null, "Andr�", "96187898648");   
		Cliente cliente02 = new Cliente (null, "Ana", "14725836912");
		
				
		@Test
		public void CadastraLoja() {
			
			//Execu��o		
			boolean retorno1 = clienteService.cadastrarCliente(cliente01);
			boolean retorno2 = clienteService.cadastrarCliente(cliente02);
			
			//Verifica��o
			assertTrue(retorno1);
			assertTrue(retorno2);
					
					
		}
		
		@Test
		public void CadastraClienteNomeBranco() {
			
			Cliente cliente = new Cliente (null, "", "96187898648"); 
			
			//Execu��o		
			boolean retorno1 = clienteService.cadastrarCliente(cliente);
			
			
			//Verifica��o
			assertTrue(retorno1);
							
					
		}
		
		@Test
		public void CadastraClienteCpfBranco() {
			
			Cliente cliente = new Cliente (null, "Maria", ""); 
			
			//Execu��o		
			boolean retorno1 = clienteService.cadastrarCliente(cliente);
			
			
			//Verifica��o
			assertTrue(retorno1);
							
					
		}
		
		@Test
		public void AlteraCliente() {
			
			//Execu��o
			Cliente cliente = new Cliente (4, "Lucas", "961875465");
			boolean retorno = clienteService.alterarCliente(cliente);
			
			//Verifica��o
			assertTrue(retorno);
					
					
		}
		
		@Test
		public void ApagaCliente() {
			
			//Execu��o		
			boolean retorno = clienteService.apagarCliente(12);
			
			
			//Verifica��o
			assertTrue(retorno);
			
			/*assertThat(retorno, is(true));
			assertThat(grupoService.size(), is(1));
			assertNull(grupoService.pesquisaCliente(2));*/
					
					
		}
		
		@Test
		public void PesquisaCliente() {
			
			
			//Execu��o		
			Cliente cliente = clienteService.pesquisarClienteId(4);
			
			
			//Verifica��o
			assertThat(cliente.getCodigoCliente(), is(4));
					
					
		}
		
		@Test
		public void PesquisaTodosClientes() {
			
			//Execu��o	
			List<Cliente> cliente = new ArrayList<Cliente>();
		    clienteService.exibirTodosCliente(cliente);
					
			
			//Verifica��o
		    assertThat(clienteService.exibirTodosClientes(), is(cliente));
					
					
		}
		
		
	}


