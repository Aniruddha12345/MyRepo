package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;





	@Entity
	@Table(name = "users")
	public class UserDetail implements Serializable {

		private static final long serialVersionUID = 1L;
		

		@Id
		@Column(name = "user_id")
		private String userId;

		@Column(name = "user_password")
		private String userPassword;
		
		@Column(name = "user_type_code")
		private Integer userTypeCode;
		

		public String getUserId() {
			return userId;
		}

		public Integer getUserTypeCode() {
			return userTypeCode;
		}

		public void setUserTypeCode(Integer userTypeCode) {
			this.userTypeCode = userTypeCode;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public String getUserPassword() {
			return userPassword;
		}

		public void setUserPassword(String userPassword) {
			this.userPassword = userPassword;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		
	}

