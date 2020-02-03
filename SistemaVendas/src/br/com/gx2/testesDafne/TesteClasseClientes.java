package br.com.gx2.testesDafne;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import br.com.gx2.entity.Cliente;
import br.com.gx2.service.ClienteService;
import br.com.gx2.service.ServiceFactory;



public class TesteClasseClientes {
			
		//Montagem cenário
		ClienteService clienteService = ServiceFactory.createClienteService();
		
		String nome1 = "André";
		String nome2 = "Ana";
		String cpf1 = "96187898648";
		String cpf2 = "14725836912";
	
		
		Cliente cliente01 = new Cliente (null, nome1, cpf1);   
		Cliente cliente02 = new Cliente (null, nome2, cpf2);
		
				
		@Test
		public void CadastraLoja() {
			
			//Execução		
			boolean retorno1 = clienteService.cadastrarCliente(cliente01);
			boolean retorno2 = clienteService.cadastrarCliente(cliente02);
			
			//Verificação
			assertTrue(retorno1);
			assertTrue(retorno2);
					
					
		}
		
		@Test
		public void CadastraClienteNomeBranco() {
			
			Cliente cliente = new Cliente (null, "", "96187898648"); 
			
			//Execução		
			boolean retorno1 = clienteService.cadastrarCliente(cliente);
			
			
			//Verificação
			assertTrue(retorno1);
							
					
		}
		
		@Test
		public void CadastraClienteCpfBranco() {
			
			Cliente cliente = new Cliente (null, "Maria", ""); 
			
			//Execução		
			boolean retorno1 = clienteService.cadastrarCliente(cliente);
			
			
			//Verificação
			assertTrue(retorno1);
							
					
		}
		
		@Test
		public void AlteraCliente() {
			
			//Execução
			Cliente cliente = new Cliente (4, "Lucas", "961875465");
			boolean retorno = clienteService.alterarCliente(cliente);
			
			//Verificação
			assertTrue(retorno);
					
					
		}
		
		@Test
		public void ApagaCliente() {
			
			//Execução		
			boolean retorno = clienteService.apagarCliente(12);
			
			
			//Verificação
			assertTrue(retorno);
			
			/*assertThat(retorno, is(true));
			assertThat(grupoService.size(), is(1));
			assertNull(grupoService.pesquisaCliente(2));*/
					
					
		}
		
		@Test
		public void PesquisaCliente() {
			
			
			//Execução		
			Cliente cliente = clienteService.pesquisarClienteId(4);
			
			
			//Verificação
			assertThat(cliente.getCodigoCliente(), is(4));
					
					
		}
		
		@Test
		public void PesquisaTodosClientes() {
			
			//Execução	
		    clienteService.exibirTodosClientes();
					
			
			//Verificação
		    assertThat(clienteService.exibirTodosClientes().size(), is (9));
					
					
		}
		
		
	}


