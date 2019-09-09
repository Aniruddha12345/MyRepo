package model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="stud_dtl")
public class StudentDetail implements Serializable {
	

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="stud_id")
	private Integer studentId;
	
	@Column(name="age")
	private Integer age;
	
	@OneToOne
	@JoinColumn(name="dept_id")
	private StudentDepartment studDepartment;
	
	@Column(name="dob")
	private Date dateOfBirth;
	
	@Column(name="father_name")
	private String fatherName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="hobbies")
	private String hobbies;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="local_address")
	private String localAddress;
	
	@Column(name="mob")
	private Long mobileNo;
	
	@Column(name="mother_name")
	private String motherName;
	
	@Column(name="permanent_address")
	private String permanentAddress;
	
	@Column(name="place_of_birth")
	private String placeOfBirth;
	
	@Column(name="ssc_score")
	private Integer sscScore;
	
	@Column(name="gender")
	private String gender;
	
	@OneToOne
	@JoinColumn(name="state_id")
	private State state; 
	
	@Column(name="user_id")
	private String userId;
	
	@OneToOne
	@JoinColumn(name="city_id")
	private City city;

	public Integer getStudentId() {
		return studentId;
	}

	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public StudentDepartment getStudDepartment() {
		return studDepartment;
	}

	public void setStudDepartment(StudentDepartment studDepartment) {
		this.studDepartment = studDepartment;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocalAddress() {
		return localAddress;
	}

	public void setLocalAddress(String localAddress) {
		this.localAddress = localAddress;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public void setPlaceOfBirth(String placeOfBirth) {
		this.placeOfBirth = placeOfBirth;
	}

	public Integer getSscScore() {
		return sscScore;
	}

	public void setSscScore(Integer sscScore) {
		this.sscScore = sscScore;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	
	
	
	

}
