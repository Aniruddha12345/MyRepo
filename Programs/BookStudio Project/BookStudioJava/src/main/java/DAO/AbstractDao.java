package DAO;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 * Abstract base class for all DAOs
 * 
 * @author Rolta
 * @see {@link IGenericDao}
 */
public abstract class AbstractDao<T, ID extends Serializable> implements
		IGenericDao<T, ID> {

	@PersistenceContext
	public EntityManager entityManager;
	


	/**
	 * 
	 * The class of object this DAO persists
	 */
	protected Class<T> persistentClass;

	/**
	 * Default Constructor
	 */
	@SuppressWarnings("unchecked")
	public AbstractDao() {
		Type t = getClass().getGenericSuperclass();
		
		if(!(t instanceof ParameterizedType)) {
			t= getClass().getSuperclass().getGenericSuperclass();
		}
		ParameterizedType pt = (ParameterizedType) t;
		this.persistentClass = (Class<T>) pt.getActualTypeArguments()[0];
		
	}

	public long countAll() {
		return (Long) countAll(null);	
	}

	
	public long countAll(final Map<String, Object> params) {
		final StringBuffer queryString = new StringBuffer("SELECT count(0) from ");
		queryString.append(persistentClass.getSimpleName()).append(" t ");
		queryString.append(this.getQueryClauses(params, null));
		final Query query = this.entityManager.createQuery(queryString.toString());
		return (Long) query.getSingleResult();
	}

	public T findById(ID id) {
		T t = entityManager.find(this.persistentClass, id);
		return t;
	}

	public Collection<T> findAll() {
		return findAll(null);	}

	
		
	
	@SuppressWarnings("unchecked")
	public Collection<T> findAll(Map<String, String> orderParams) {
		StringBuffer queryString = new StringBuffer("SELECT t FROM " + this.persistentClass.getName() + " t");
		queryString.append(this.getQueryClauses(null, orderParams));
		Query query = this.entityManager.createQuery(queryString.toString());
		Collection<T> collection = (Collection<T>) query.getResultList();

		return collection;
	}

	
	@SuppressWarnings("unchecked")
	public Collection<T> findAllForTenant(Map<String, Object> orderParams) {
		StringBuffer queryString = new StringBuffer("SELECT t FROM " + this.persistentClass.getName() + " t");
		queryString.append(this.getQueryClauses(orderParams, null));
		Query query = this.entityManager.createQuery(queryString.toString());
		Collection<T> collection = (Collection<T>) query.getResultList();

		return collection;
	}
	
	public T save(final T entity) {
		this.entityManager.persist(entity);
		return entity;
	}

	public void delete(final ID id) {
		this.entityManager.remove(this.entityManager.getReference(persistentClass, id));
	}

	public void delete(final T entity) {
		this.entityManager.remove(entity);
	}

	public T update(final T t) {
		return this.entityManager.merge(t);
	}
	
	/**
	 * Return sub-query for parameters & order-by
	 * @param params {@link Map} whose key is the columnName and value is the column value.
	 * @param orderParams {@link Map} whose key is the columnName and value is either to 
	 * 								denote Ascending, Descending or Operator. <br /> 
	 * 			For e.g. order-by clause for postgres is : ORDER BY expression [ ASC | DESC | USING operator ] [, ...]
	 * @return {@link String}
	 */
	public String getQueryClauses(final Map<String, Object> params, 
			final Map<String, String> orderParams) {
		final StringBuffer queryString = new StringBuffer();
		if ((params != null) && !params.isEmpty()) {
			queryString.append(" WHERE ");
			for (final Iterator<Map.Entry<String, Object>> it = params.entrySet().iterator(); it.hasNext();) {
				final Map.Entry<String, Object> entry = it.next();
				if (entry.getValue() instanceof Boolean) {
					queryString.append(entry.getKey()).append(" IS ")
							.append(entry.getValue()).append(" ");
				} else {
					if (entry.getValue() instanceof Number) {
						queryString.append(entry.getKey()).append(" = ")
								.append(entry.getValue());
					} else {
						// string equality
						queryString.append(entry.getKey()).append(" = '")
								.append(entry.getValue()).append("'");
					}
				}
				if (it.hasNext()) {
					queryString.append(" AND ");
				}
			}
		}
		if ((orderParams != null) && !orderParams.isEmpty()) {
			queryString.append(" ORDER BY ");
			for (final Iterator<Map.Entry<String, String>> it = orderParams.entrySet().iterator(); it.hasNext();) {
				final Map.Entry<String, String> entry = it.next();
				queryString.append(entry.getKey()).append(" ");
				if (entry.getValue() != null) {
					queryString.append(entry.getValue());
				}
				if (it.hasNext()) {
					queryString.append(", ");
				}
			}
		}
		return queryString.toString();
	}
}