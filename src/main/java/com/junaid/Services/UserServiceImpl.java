package com.junaid.Services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.junaid.Models.TaskModel;
import com.junaid.Models.UserModel;
import com.junaid.Repo.TaskRepo;
import com.junaid.Repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private TaskRepo taskRepo;

	@Override
	public List<UserModel> getUser() {
		return userRepo.findAll();
	}

	@Override
	public List<UserModel> setUser(UserModel um) {
		userRepo.save(um);
		return getUser();
	}

	@Override
	public List<UserModel> removeUser(long parseLong) {
		userRepo.deleteById(parseLong);
		return getUser();
	}

	@Override
	public UserModel getUserbyId(long parseLong) {
		return userRepo.findById(parseLong).get();
	}
	
	@Override
	public Set<TaskModel> getUsertasksbyId(long parseLong) {
		return userRepo.findById(parseLong).get().getTasks();
	}
	
	@Override
	public UserModel putUser(long Userid, UserModel um) {
		um.setUid(Userid);
		for (TaskModel tm : um.getTasks()) {
			tm.setUid((int)Userid);
		}
		setUser(um);
		return userRepo.getById(Userid);
	}

	@Override
	public Set<TaskModel> setUsertask(long parseLong,TaskModel um) {
		taskRepo.save(um);
		return getUsertasksbyId(parseLong);
	}

	@Override
	public UserModel putUsertask(Long userid,Long taskid, TaskModel um) {
		um.setUid(userid.intValue());
		um.setTask_id(taskid.intValue());
		taskRepo.save(um);
		return userRepo.findById(userid).get();
	}

	@Override
	public UserModel removeUsertask(long userid, long taskid) {
		taskRepo.deleteById(taskid);
		return userRepo.findById(userid).get();
	}

}