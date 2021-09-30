package com.example.demo.Domain;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Entity

public class Animals {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private long id;
	private String firstname;
	private String lastname;
	private String type;
	private int jumpheight;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getJumpheight() {
		return jumpheight;
	}

	public void setJumpheight(int jumpheight) {
		this.jumpheight = jumpheight;
	}



	public Animals(long id, String firstname, String lastname, String type, int jumpheight) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = type;
		this.jumpheight = jumpheight;
	}

	public Animals(String firstname, String lastname, String type, int jumpheight) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.type = type;
		this.jumpheight = jumpheight;
	}

	public Animals(String firstname, String lastname) {
		super();

		this.firstname = firstname;
		this.lastname = lastname;

	}

	public Animals() {
		super();

	}

	@Override
	public String toString() {
		return "Animals [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", type=" + type
				+ ", jumpheight=" + jumpheight + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(firstname, id, jumpheight, lastname, type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animals other = (Animals) obj;
		return Objects.equals(firstname, other.firstname) && id == other.id && jumpheight == other.jumpheight
				&& Objects.equals(lastname, other.lastname) && Objects.equals(type, other.type);
	}

}
