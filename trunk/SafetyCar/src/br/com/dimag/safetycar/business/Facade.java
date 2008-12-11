package br.com.dimag.safetycar.business;

import java.util.List;

import br.com.dimag.safetycar.business.cadastro.CadastroAutomovel;
import br.com.dimag.safetycar.business.cadastro.CadastroCliente;
import br.com.dimag.safetycar.business.cadastro.CadastroEndereco;
import br.com.dimag.safetycar.business.cadastro.CadastroFuncionario;
import br.com.dimag.safetycar.business.cadastro.CadastroOrdemServico;
import br.com.dimag.safetycar.business.cadastro.CadastroProduto;
import br.com.dimag.safetycar.business.cadastro.CadastroServico;
import br.com.dimag.safetycar.business.cadastro.CadastroUF;
import br.com.dimag.safetycar.business.cadastro.CadastroUsuario;
import br.com.dimag.safetycar.exception.DadosInsuficientesException;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.exception.FacadeException;
import br.com.dimag.safetycar.model.Automovel;
import br.com.dimag.safetycar.model.Cliente;
import br.com.dimag.safetycar.model.Endereco;
import br.com.dimag.safetycar.model.Funcionario;
import br.com.dimag.safetycar.model.OrdemServico;
import br.com.dimag.safetycar.model.Produto;
import br.com.dimag.safetycar.model.Servico;
import br.com.dimag.safetycar.model.UF;
import br.com.dimag.safetycar.model.Usuario;
import br.com.dimag.safetycar.model.Pessoa.TipoPessoa;

public class Facade {

	private static Facade facade;
	private CadastroCliente cadastroCliente;
	private CadastroAutomovel cadastroAutomovel;
	private CadastroOrdemServico cadastroOrdemServico;
	private CadastroUF cadastroUf;
	private CadastroFuncionario cadastroFuncionario;
	private CadastroServico cadastroServico;
	private CadastroProduto cadastroProduto;
	private CadastroEndereco cadastroEndereco;
	private CadastroUsuario cadastroUsuario;


	public static Facade getInstance(){
		if (facade == null){
			facade = new Facade();
		}
		return facade;
	}

	private Facade(){
		try {
			cadastroCliente = new CadastroCliente();
			cadastroAutomovel = new CadastroAutomovel();
			cadastroOrdemServico = new CadastroOrdemServico();
			cadastroUf = new CadastroUF();
			cadastroFuncionario = new CadastroFuncionario();

			cadastroProduto = new CadastroProduto();

			cadastroServico = new CadastroServico();
			cadastroProduto = new CadastroProduto();
			cadastroEndereco = new CadastroEndereco();
			cadastroUsuario = new CadastroUsuario();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void cadastrarCliente(Cliente cliente) throws FacadeException{
		
		try {
			cadastroCliente.inserir(cliente);
		} catch (DadosInsuficientesException e) {
			throw new FacadeException("Erro ao tentar inserir um cliente. Dados Insuficientes.");
		} catch (DataException e) {
			throw new FacadeException("Erro ao nos dados");
		}
	}
	
	
	public static void main(String[] args) {
		Cliente c = new Cliente();
		c.setNomeRazaoSocial("Cliente");
		c.setCpfCnpj("123456");
		c.setNomeRazaoSocial("Cliente");
		
		c.setTipoPessoa(TipoPessoa.FISICA);
		
		try {
			Facade.getInstance().cadastrarCliente(c);
		} catch (FacadeException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		Facade.getInstance().listCliente();
		
		System.out.println("ACABOU!!!!!!!!!!!!!!!!!!!!!!");
	}
	
	public List<Automovel> searchListAutomovel(Cliente cliente){
		
		return cadastroOrdemServico.listAutomovel(cliente);
	}

	public List<Cliente> listCliente() {
		return cadastroCliente.list();
	}

	public List<UF> listUf() {
		return cadastroUf.list();
	}

	public List<Automovel> listAutomovel() {
		return cadastroAutomovel.list();
	}

	public List<OrdemServico> listOrdemServico() {
		return cadastroOrdemServico.list();
	}

	public void cadastrarOrdemServico(OrdemServico ordemServico) throws DadosInsuficientesException, DataException {
		cadastroOrdemServico.inserir(ordemServico);
	}

	public List<Funcionario> listAtendente() {
		return cadastroFuncionario.listAtendente();
	}

	public void atualizarCliente(Cliente cliente) throws FacadeException {
		try {
			cadastroCliente.atualizar(cliente);
		} catch (DadosInsuficientesException e) {
			throw new FacadeException(e.getMessage());
		}
	}


	public void cadastrarProduto(Produto produto) throws DadosInsuficientesException, DataException, FacadeException {
		// TODO Auto-generated method stub
		try {
			cadastroProduto.inserir(produto);
		} catch (DadosInsuficientesException e) {
			throw new FacadeException(e.getMessage());
		}
	}

	public void atualizarProduto(Produto produto) throws FacadeException {
		// TODO Auto-generated method stub
		try {
			cadastroProduto.atualizar(produto);
		} catch (DadosInsuficientesException e) {
			throw new FacadeException(e.getMessage());
		}
	}

	public void cadastrarAutomovel(Automovel automovel) throws DadosInsuficientesException, DataException {
		cadastroAutomovel.inserir(automovel);
	}

	public void atualizarAutomovel(Automovel automovel) throws DadosInsuficientesException {
		cadastroAutomovel.atualizar(automovel);
	}

	public List<Servico> listServico() {
		return cadastroServico.list();
	}

	public List<Produto> listProduto() {
		return cadastroProduto.list();
	}

	public List<Funcionario> listMecanico() {
		return cadastroFuncionario.listMecanico();
	
	}
	//ATUALIZAR OS
	public void atualizarOrdemServico(OrdemServico ordemServico) throws DadosInsuficientesException {
		cadastroOrdemServico.atualizar(ordemServico);
	}
	//ATUALIZAR SERVIÇO
	public void atualizarServico(Servico servico) throws DadosInsuficientesException, DataException, FacadeException {
		// TODO Auto-generated method stub
		try {
			cadastroServico.atualizar(servico);
		} catch (DadosInsuficientesException e) {
			throw new FacadeException(e.getMessage());
		}

	}

	public void cadastrarServico(Servico servico) throws DadosInsuficientesException, DataException, FacadeException {
		// TODO Auto-generated method stub
		try {
			cadastroServico.inserir(servico);
		} catch (DadosInsuficientesException e) {
			throw new FacadeException(e.getMessage());
		}
		
	}


	public List<Servico> searchListServicoByDescricao(String descricao) {
		return cadastroServico.searchListServicoByDescricao(descricao);
		
	}


	public Endereco findEnderecoBaseByCep(String cep) {
		return cadastroEndereco.findEnderecoBaseByCep(cep);
		
	}
	//Autenticação de Usuário
	public Usuario autenticacaoUsuario(String login, String senha) {
		// TODO Auto-generated method stub
		return cadastroUsuario.autenticacaoUsuario(login,senha);
	}
	public List<OrdemServico> searchListOSByPlaca(String placa) {
		return cadastroOrdemServico.searchListServicoByDescricao(placa);
	}

	public void atualizarUsuario(Usuario usuario) throws DadosInsuficientesException, DataException, FacadeException {
		// TODO Auto-generated method stub
		try {
			cadastroUsuario.atualizar(usuario);
		} catch (DadosInsuficientesException e) {
			throw new FacadeException(e.getMessage());
		}

	}

	public void cadastrarUsuario(Usuario usuario)throws DadosInsuficientesException, DataException, FacadeException {
		// TODO Auto-generated method stub
		try {
			cadastroUsuario.inserir(usuario);
		} catch (DadosInsuficientesException e) {
			throw new FacadeException(e.getMessage());
		}
	}

	public List<Usuario> listUsuario() {
		// TODO Auto-generated method stub
		return cadastroUsuario.list();
	}

	public List<Usuario> searchListUsuarioByLogin(String login) {
		// TODO Auto-generated method stub
		return cadastroUsuario.searchListServicoByDescricao(login);
	}
}
	
	
	

