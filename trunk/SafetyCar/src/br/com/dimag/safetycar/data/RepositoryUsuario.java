package br.com.dimag.safetycar.data;

import java.util.List;

import br.com.dimag.safetycar.data.api.IRepositoryUsuario;
import br.com.dimag.safetycar.data.transaction.HibernateInterceptorAnnotation;
import br.com.dimag.safetycar.data.transaction.HibernateTransaction;
import br.com.dimag.safetycar.data.transaction.HibernateUtil;
import br.com.dimag.safetycar.data.transaction.TransactionClass;
import br.com.dimag.safetycar.exception.DataException;
import br.com.dimag.safetycar.model.Usuario;

public abstract class RepositoryUsuario implements IRepositoryUsuario {

	private static RepositoryUsuario instance;

	private Class<Usuario> clazz = Usuario.class;

	public static RepositoryUsuario getInstance() throws DataException {
		if (instance == null) {
			try {
				instance = (RepositoryUsuario) TransactionClass.create(
						RepositoryUsuario.class,
						HibernateInterceptorAnnotation.class);
			} catch (Exception e) {
				throw new DataException(e);
			}
		}
		return instance;
	}

	@Override
	@HibernateTransaction
	public void delete(Usuario usuario) {
		HibernateUtil.getSession().delete(usuario);
	}

	@Override
	@HibernateTransaction
	public void insert(Usuario usuario) {
		HibernateUtil.getSession().save(usuario);
	}

	@Override
	@HibernateTransaction
	public void update(Usuario usuario) {
		HibernateUtil.getSession().update(usuario);
	}

	@Override
	@SuppressWarnings("unchecked")
	@HibernateTransaction
	public List<Usuario> list() {
		return  HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName()).list();
	}

	public Usuario autenticacaoUsuario(String login, String senha) {
		return (Usuario)HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName()+ " u where u.login = :login and u.password = :pass ").setParameter("login",	login).setParameter("pass", senha).uniqueResult();
	}

	
	@SuppressWarnings("unchecked")
	public List<Usuario> searchListServicoByDescricao(String login) {
		return HibernateUtil.getSession().createQuery(
				"from " + clazz.getSimpleName() +" s where s.login like lower( :login ) " ).setParameter("login", "%"+login.toLowerCase()+"%" ).list();
	
	}
}