package com.junaid.Models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tasktest")
public class TaskModel {

	@Override
	public String toString() {
		return "TaskModel [task_id=" + task_id + ", name=" + name + ", desc=" + descr + "]";
	}

	@Id
	@Column(name = "task_id", unique = true)
	long task_id;
	
	@Column
	String name;
	
	@Column
	String descr;
	
	@Column(name = "Uid")
    private Integer Uid;

	public void setDescr(String descr) {
		this.descr = descr;
	}

	public Integer getUid() {
		return Uid;
	}

	public void setUid(Integer uid) {
		Uid = uid;
	}
	
	public TaskModel(long task_id, String name, String descr, Integer uid) {
		super();
		this.task_id = task_id;
		this.name = name;
		this.descr = descr;
		Uid = uid;
	}

	public long getTask_id() {
		return task_id;
	}

	public void setTask_id(long task_id) {
		this.task_id = task_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescr() {
		return descr;
	}

	public TaskModel() {
		super();
	}

}