package DAO;

// Imports
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;

/**
 * Generic Dao interface
 * 
 * @author Rolta
 * 
 * @see Absta
 */
public interface IGenericDao<T, ID extends Serializable> {

	/**
	 * Method that returns the number of entries from a table
	 * 
	 * @return the number of records meeting the criteria
	 */
	long countAll();

	/**
	 * Method that returns the number of entries from a table that meet some
	 * criteria (where clause params)
	 * 
	 * @param params
	 *            sql parameters
	 * @return the number of records meeting the criteria
	 */
	long countAll(Map<String, Object> params);

	/**
	 * Gets a persisted entity of type T with the given id
	 * 
	 * @param id
	 *            the entity id
	 * @return an entity of type T or null
	 */
	T findById(ID id);

	/**
	 * Gets all persisted entities of type T
	 * 
	 * @return a collection of entities or null
	 */
	Collection<T> findAll();

	/**
	 * Gets all persisted entities of type T in order
	 * 
	 * @return a collection of entities or null
	 */
	Collection<T> findAll(Map<String, String> orderParams);

	/**
	 * Persists an entity of type T
	 * 
	 * @param entity
	 *            the entity to persist
	 * @return the saved entity
	 */
	T save(T entity);

	/**
	 * Deletes an entity with the given id
	 * 
	 * @param id
	 *            the id of the entity to delete
	 */
	void delete(ID id);

	/**
	 * Deletes an entity of type T
	 * 
	 * @param entity
	 *            the entity to delete
	 */
	void delete(T entity);

	/**
	 * Update an entity of type T
	 * 
	 * @param t
	 *            entity to update
	 * @return updated entity
	 */
	T update(T t);

	Collection<T> findAllForTenant(Map<String, Object> orderParams);
}
