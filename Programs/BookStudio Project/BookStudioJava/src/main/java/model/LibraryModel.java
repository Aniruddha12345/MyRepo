package model;

import java.util.Date;

//import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
//import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "BOOK_STUDIO1")
@SequenceGenerator(name = "BOOK_STUDIO1_SEQ", sequenceName = "BOOK_STUDIO1_SEQ", allocationSize = 1)

@NamedQuery(name = "showBookDetailsByName", query = "SELECT b FROM LibraryModel b WHERE b.bk_name LIKE :bookname")
@XmlRootElement

public class LibraryModel {

	@Id

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BOOK_STUDIO1_SEQ")
	@Column(name = "BOOK_ID")
	private Integer bk_id;

	public static final String SHOW_BOOK_BY_NAME = "showBookDetailsByName";

	@Column(name = "BOOK_CATEGORY")
	String section;

	@Column(name = "BOOK_NAME")

	String bk_name;

	@Column(name = "AUTHOR_NAME")
	String author;

	@Column(name = "PUBLSH_DATE")
	Date published_date;

	@Column(name = "BOOK_ISSUED")
	Integer bk_issueflag = 0;

	@Column(name = "AUDIT_CRT_DATE")
	Date bk_crt_date;

	@Column(name = "CRT_USER")
	String bk_user;

	public Integer getBk_id() {
		return bk_id;
	}

	public void setBk_id(Integer bk_id) {
		this.bk_id = bk_id;
	}

	public String getSection() {
		return section;
	}

	public void setSection(String section) {
		this.section = section;
	}

	public String getBk_name() {
		return bk_name;
	}

	public void setBk_name(String bk_name) {
		this.bk_name = bk_name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getPublished_date() {
		return published_date;
	}

	public void setPublished_date(Date published_date) {
		this.published_date = published_date;
	}

	public Integer getBk_issueflag() {
		return bk_issueflag;
	}

	public void setBk_issueflag(Integer bk_issueflag) {
		this.bk_issueflag = bk_issueflag;
	}

	public Date getBk_crt_date() {
		return bk_crt_date;
	}

	public void setBk_crt_date(Date bk_crt_date) {
		this.bk_crt_date = bk_crt_date;
	}

	public String getBk_user() {
		return bk_user;
	}

	public void setBk_user(String bk_user) {
		this.bk_user = bk_user;
	}

	@Override
	public String toString() {
		return "JsonPojo [bk_id=" + bk_id + ", section=" + section + ", bk_name=" + bk_name + ", author=" + author
				+ ", published_date=" + published_date + ", bk_issueflag=" + bk_issueflag + ", bk_crt_date="
				+ bk_crt_date + ", bk_user=" + bk_user + ", getBk_id()=" + getBk_id() + ", getSection()=" + getSection()
				+ ", getBk_name()=" + getBk_name() + ", getAuthor()=" + getAuthor() + ", getPublished_date()="
				+ getPublished_date() + ", getBk_issueflag()=" + getBk_issueflag() + ", getBk_crt_date()="
				+ getBk_crt_date() + ", getBk_user()=" + getBk_user() + "]";
	}

}
