package com.junaid.Services;

import java.util.List;
import java.util.Set;

import com.junaid.Models.TaskModel;
import com.junaid.Models.UserModel;

public interface UserService {

	public List<UserModel> getUser();

	public List<UserModel> setUser(UserModel um);

	public List<UserModel> removeUser(long i);

	public UserModel getUserbyId(long parseLong);

	public UserModel putUser(long userid, UserModel um);

	public Set<TaskModel> getUsertasksbyId(long parseLong);

	public Set<TaskModel> setUsertask(long parseLong,TaskModel um);

	public UserModel putUsertask(Long userid, Long taskid, TaskModel um);

	public UserModel removeUsertask(long userid, long taskid);

}