package service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.transaction.Transactional;

import DAO.BookDao;
import DAO.BookDaoImpl;
import model.LibraryModel;

@Transactional
public class BookServiceImpl implements BookService {

	@Inject
	BookDao bookDao;

	public LibraryModel save(LibraryModel model) {
		LibraryModel model1 = new LibraryModel();
		model1 = bookDao.save(model);
		return model1;
	}

	public List<LibraryModel> findAll() {
		List<LibraryModel> getAllBooks = new ArrayList();
		getAllBooks = (List<LibraryModel>) bookDao.findAll();
		return getAllBooks;
	}

	public List<LibraryModel> findByName(String name) {
		List<LibraryModel> getAllBooks = new ArrayList();
		LibraryModel model1 = new LibraryModel();
		getAllBooks = bookDao.findBookByName(name);
		return getAllBooks;
	}

	public LibraryModel update(LibraryModel model) {
		LibraryModel model1 = new LibraryModel();
		model1 = bookDao.update(model);
		return model1;
	}

	public void delete(Integer id) {
		bookDao.delete(id);
	}
}