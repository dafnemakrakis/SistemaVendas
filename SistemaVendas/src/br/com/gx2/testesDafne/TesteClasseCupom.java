package br.com.gx2.testesDafne;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import br.com.gx2.entity.Cliente;
import br.com.gx2.entity.CupomFiscal;
import br.com.gx2.entity.Loja;
import br.com.gx2.entity.Vendedor;
import br.com.gx2.service.CupomFiscalService;
import br.com.gx2.service.ServiceFactory;

public class TesteClasseCupom {
	
	//Montagem cenário
			CupomFiscalService cupomService = ServiceFactory.createCupomFiscalService();
			Date date = new Date();
			
			
			Loja loja02 = new Loja (4, "Partenon");
			Loja loja03 = new Loja (9, "Centro");
			
			Cliente cliente01 = new Cliente (1, "André", "96187898648");   
			Cliente cliente02 = new Cliente (2, "Ana", "14725836912");
			
			Vendedor vendedor01 = new Vendedor (1, "0521", "Neiva");   
			Vendedor vendedor02 = new Vendedor (2, "6588", "Antonio");
			
			
			CupomFiscal cupom01 = new CupomFiscal (null, 100.00, date, loja02, cliente01, vendedor01);
			/*CupomFiscal cupom02 = new CupomFiscal (null, 250.00, new Date(), loja03, cliente01, vendedor01);
			CupomFiscal cupom03 = new CupomFiscal (null, 180.00, new Date(), loja02, cliente02, vendedor02);
			CupomFiscal cupom04 = new CupomFiscal (null, 129.00, new Date(), loja02, cliente01, vendedor01);
			CupomFiscal cupom05 = new CupomFiscal (null, 180.00, new Date(), loja03, cliente02, vendedor02);*/

			
			@Test
			public void CadastraCupom() {
				
				//Execução		
				boolean retorno1 = cupomService.cadastrarCupomFiscal(cupom01);
				/*boolean retorno2 = cupomService.cadastrarCupomFiscal(cupom02);
				boolean retorno3 = cupomService.cadastrarCupomFiscal(cupom03);
				boolean retorno4 = cupomService.cadastrarCupomFiscal(cupom04);
				boolean retorno5 = cupomService.cadastrarCupomFiscal(cupom05);*/
				
				//Verificação
				assertTrue(retorno1);
				/*assertTrue(retorno2);
				assertTrue(retorno3);
				assertTrue(retorno4);
				assertTrue(retorno5);*/
						
						
			}
			
			@Test
			public void CadastraCupomValorBranco() {
				
				CupomFiscal cupom = new CupomFiscal (null, null, date, loja02, cliente01, vendedor01);
				
				//Execução		
				boolean retorno1 = cupomService.cadastrarCupomFiscal(cupom);
				
				
				//Verificação
				assertTrue(retorno1);
				
						
						
			}
			
			@Test
			public void AlteraValorCupom() {
				
				//Execução
				CupomFiscal cupom = new CupomFiscal (5, 500.00, new Date(), loja02, cliente01, vendedor01);
				boolean retorno = cupomService.alterarCupomFiscal(cupom);
				
				//Verificação
				assertTrue(retorno);
						
						
			}
			
			@Test
			public void ApagaCupom() {
				
				//Execução		
				boolean retorno = cupomService.apagarCupomFiscal(12);
				
				
				//Verificação
				assertTrue(retorno);
				
				/*assertThat(retorno, is(true));
				assertThat(grupoService.size(), is(1));
				assertNull(grupoService.pesquisaCliente(2));*/
						
						
			}
			
			@Test
			public void PesquisaCupom() {
				
				
				//Execução		
			CupomFiscal cupom = cupomService.pesquisarCupomFiscalId(4);
				
				
				//Verificação
				assertThat(cupom.getCodigoCupom(), is(4));
						
						
			}
			
			@Test
			public void PesquisaTodosCupons() {
				
				//Execução	
				
				cupomService.exibirTodosCuponsFiscais();
						
				
				//Verificação
				assertThat(cupomService.exibirTodosCuponsFiscais().size(), is (0));
						
						
			}

}
