package service;

import java.util.List;

import model.LibraryModel;

public interface BookService {

	public LibraryModel save(LibraryModel model);

	public List<LibraryModel> findAll();

	public List<LibraryModel> findByName(String name);

	// public LibraryModel findById(Integer id);

	public LibraryModel update(final LibraryModel model);

	public void delete(Integer id);

}
