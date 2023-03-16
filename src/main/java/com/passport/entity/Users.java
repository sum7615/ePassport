package com.passport.entity;

<<<<<<< HEAD
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Users {
	@Id
	private long id;
	private String username;
=======
import java.time.LocalDate;
>>>>>>> 0fd646daf8b8098540c22bbe7693b1132d52fa83



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;




@Entity
@Table(name="users", uniqueConstraints = @UniqueConstraint(name = "username_unique", columnNames = "username"))
public class Users{

	@Id
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_sequence"
    )
    @Column(name = "id", updatable = false)
    private Long id;
	
//	@NotBlank(message = "Name is not valid")
//	@Pattern(regexp ="^[a-zA-Z][a-zA-Z\\s]{0,20}[a-zA-Z]$")
	private String name;
	
	@Column(unique=true, name="username")
//	@NotBlank(message = "Username is not valid")
//    @UniqueElements(message="Username is duplicate")
	private String username;
	private LocalDate dob;
	private String gender;
	private String phone;
	private String presentAddress;
	private String permanentAddress;
	private String password;
	private String roles;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPresentAddress() {
		return presentAddress;
	}
	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}
	public String getPermanentAddress() {
		return permanentAddress;
	}
	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRoles() {
		return roles;
	}
	public void setRoles(String roles) {
		this.roles = roles;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", name=" + name + ", username=" + username + ", dob=" + dob + ", gender=" + gender
				+ ", phone=" + phone + ", presentAddress=" + presentAddress + ", permanentAddress=" + permanentAddress
				+ ", password=" + password + ", roles=" + roles + "]";
	}
	public Users(Long id, String name, String username, LocalDate dob, String gender, String phone,
			String presentAddress, String permanentAddress, String password, String roles) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.dob = dob;
		this.gender = gender;
		this.phone = phone;
		this.presentAddress = presentAddress;
		this.permanentAddress = permanentAddress;
		this.password = password;
		this.roles = roles;
	}
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
