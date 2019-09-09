package DAO;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import model.LibraryModel;

public class BookDaoImpl extends AbstractDao<LibraryModel, Serializable> implements BookDao {

	// wildcard search for book name
	public List<LibraryModel> findBookByName(String name) {
		System.out.println(name);
		Query query = entityManager.createNamedQuery(LibraryModel.SHOW_BOOK_BY_NAME).setParameter("bookname",
				"%" + name + "%");

		// This is for single output
		// return (LibraryModel) query.getSingleResult();
		return (List<LibraryModel>) query.getResultList();
	}
}
