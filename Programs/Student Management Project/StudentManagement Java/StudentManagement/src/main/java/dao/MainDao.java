package dao;

import java.util.List;

import VO.RegistrationVO;
import model.City;
import model.State;
import model.StudentDepartment;
import model.StudentDetail;
import model.UserDetail;

public interface MainDao {

	public UserDetail validateCredentials(UserDetail userDetail) throws Exception;
	
	public List<State> getAllStates();
	
	public List<City> getCities(Integer stateId);
	
	public List<StudentDetail> getStudentData();
	
	public List<StudentDepartment> getDepartments();
	
	public void saveStudent(RegistrationVO registrVo);
}
