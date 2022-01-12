package com.junaid.Models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel {

	@Id
	@Column(name = "Uid",unique = true)
	@GeneratedValue(strategy = GenerationType.TABLE)
	long Uid;
	
	@Column
	String firstname;
	
	@Column
	String lastname;

	@OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "Uid", referencedColumnName = "Uid")
	Set<TaskModel> tasks;

	public long getUid() {
		return Uid;
	}

	public void setUid(long uid) {
		Uid = uid;
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

	public Set<TaskModel> getTasks() {
		return tasks;
	}

	public void setTasks(Set<TaskModel> tasks) {
		this.tasks = tasks;
	}

	public UserModel(long uid, String firstname, String lastname, Set<TaskModel> tasks) {
		super();
		Uid = uid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.tasks = tasks;
	}

	public UserModel() {
		super();
	}
	
	
	
}
