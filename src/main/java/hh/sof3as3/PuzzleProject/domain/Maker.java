package hh.sof3as3.PuzzleProject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Maker {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long makerId;
	private String firstname;
	private String lastname;
	private int age;
	// completions

	public Maker() {
	}

	// constructors
	public Maker(String firstname, String lastname, int age) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.age = age;
	}

	// getters and setters
	public Long getMakerId() {
		return makerId;
	}

	public void setMakerId(Long makerId) {
		this.makerId = makerId;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	// toString
	@Override
	public String toString() {
		return "Maker [makerId=" + makerId + ", firstname=" + firstname + ", lastname=" + lastname + ", age=" + age
				+ "]";
	}

}
