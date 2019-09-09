package DAO;

import java.io.Serializable;
import java.util.List;

import model.LibraryModel;

public interface BookDao extends IGenericDao<LibraryModel, Serializable> {
	
	
	public List<LibraryModel> findBookByName(String name);
	
	
}
