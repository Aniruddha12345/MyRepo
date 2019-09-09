package dao;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

import VO.RegistrationVO;
import model.City;
import model.State;
import model.StudentDepartment;
import model.StudentDetail;
import model.UserDetail;

public class MainDaoImpl implements MainDao {

	@Inject
	UserDetail userDetail;

	@Inject
	State state;

	private EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("persist1");
	private EntityManager entitymanager = emfactory.createEntityManager();

	public UserDetail validateCredentials(UserDetail userDetail) throws Exception {
		Query query = entitymanager
				.createQuery(
						"from UserDetail where user_id=:id and user_password=:password and user_type_code=:loginOption")
				.setParameter("id", userDetail.getUserId()).setParameter("password", userDetail.getUserPassword())
				.setParameter("loginOption", userDetail.getUserTypeCode());

		userDetail = (UserDetail) query.getSingleResult();

		System.out.println(userDetail);

		return userDetail;

	}

	public List<State> getAllStates() {
		Query query = entitymanager.createQuery("from State");
		List<State> stateList = null;
		stateList = query.getResultList();
		return stateList;
	}

	public List<City> getCities(Integer stateId) {

		Query query = entitymanager.createQuery("from City where state_id=:stateId").setParameter("stateId", stateId);
		List<City> cityList = query.getResultList();
		return cityList;
	}

	public List<StudentDepartment> getDepartments() {
		Query query = entitymanager.createQuery("from StudentDepartment");
		List<StudentDepartment> departmentList = query.getResultList();
		return departmentList;
	}

	public List<StudentDetail> getStudentData() {

		Query query = entitymanager.createQuery("from StudentDetail");
		List<StudentDetail> studDtlList = query.getResultList();

		return studDtlList;
	}

	@Transactional
	public void saveStudent(RegistrationVO registrVo) {
		Integer stateId =Integer.parseInt(registrVo.getStateId()); 
		Integer cityId = Integer.parseInt(registrVo.getCityId());
		Integer deptId = Integer.parseInt(registrVo.getDepartmentId());
		Query query1 = entitymanager
				.createNativeQuery("insert into public.stud_dtl "
						+ "(age, dept_id, dob, father_name, first_name, hobbies, last_name, local_address, mob, mother_name, permanent_address, place_of_birth, ssc_score, gender, user_id, state_id, city_id,stud_id) VALUES"
						+ "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, nextval('stud_id_seq'))")
				.setParameter(1, registrVo.getAge()).setParameter(2, deptId)
				.setParameter(3, registrVo.getDateOfBirth()).setParameter(4, registrVo.getFatherName())
				.setParameter(5, registrVo.getFirstName()).setParameter(6, registrVo.getHobbies())
				.setParameter(7, registrVo.getLastName()).setParameter(8, registrVo.getLocalAddress())
				.setParameter(9, registrVo.getMobileNo()).setParameter(10, registrVo.getMotherName())
				.setParameter(11, registrVo.getPermanentAddress()).setParameter(12, registrVo.getPlaceOfBirth())
				.setParameter(13, registrVo.getSscScore()).setParameter(14, registrVo.getGender())
				.setParameter(15, registrVo.getUserId()).setParameter(16, stateId)
				.setParameter(17, cityId);

		entitymanager.getTransaction().begin();

		int flag1 = query1.executeUpdate();

		
		// for random password generation
		int StringCount = 5;
		String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
		StringBuilder builder = new StringBuilder();
		while (StringCount-- != 0) {
			int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
			builder.append(ALPHA_NUMERIC_STRING.charAt(character));
		}
		String passWord = builder.toString();
		
		Query query2 = entitymanager.createNativeQuery("INSERT INTO public.users(user_id, user_password, user_type_code)VALUES (?, ?, 2)")
				.setParameter(1, registrVo.getUserId())
				.setParameter(2, passWord);
		
		int flag2 = query2.executeUpdate();
		
		
		entitymanager.getTransaction().commit();
	}

}
