package controller;

import java.util.List;

import javax.inject.Inject;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import VO.RegistrationVO;
import dao.MainDao;
import model.City;
import model.State;
import model.StudentDepartment;
import model.StudentDetail;
import model.UserDetail;

@Path("/main")
public class MainController {

	@Inject
	MainDao mainDao;

	@POST
	@Path("/validateCredentials")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public Response validateCredentials(UserDetail userDetail) {

		System.out.println("Inside method");
		UserDetail usrDtl;
		try {
			usrDtl = mainDao.validateCredentials(userDetail);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.ok("error while authentication").status(500).build();
		}

		return Response.ok(usrDtl).status(200).build();
	}

	@GET
	@Path("/getAllStates")
	@Produces({ "application/json" })
	public Response getAllStates() {
		List<State> stateList = null;
		stateList = mainDao.getAllStates();
		return Response.ok(stateList).status(200).build();
	}

	@GET
	@Path("/getCities/{stateId}")
	@Produces({ "application/json" })
	public Response getCities(@PathParam("stateId") Integer stateId) {

		List<City> cityList = null;
		cityList = mainDao.getCities(stateId);

		return Response.ok(cityList).status(200).build();

	}

	@GET
	@Path("/getDepartments")
	@Produces({ "application/json" })
	public Response getDepartments() {
		List<StudentDepartment> departmentList = mainDao.getDepartments();
		return Response.ok(departmentList).status(200).build();
	}

	@GET
	@Path("/getStudentData")
	@Produces({ "application/json" })
	public Response getStudentData() {

		List<StudentDetail> studDtlList = null;
		studDtlList = mainDao.getStudentData();

		return Response.ok(studDtlList).status(200).build();

	}

	@POST
	@Path("/saveStudent")
	@Consumes({ "application/json" })
	@Produces({ "application/json" })
	public Response saveStudent(RegistrationVO registrVo) {

		System.out.println(registrVo);
		mainDao.saveStudent(registrVo);
		String resultString = "Success";
		return Response.ok(resultString).status(200).build();

	}

}