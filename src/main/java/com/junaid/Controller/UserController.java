package com.junaid.Controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.junaid.Models.TaskModel;
import com.junaid.Models.UserModel;
import com.junaid.Services.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	//done
	@GetMapping("/api/Users")
	public List<UserModel> Users(){
		return userService.getUser();
	}

	//done
	@GetMapping("/api/Users/{Userid}")
	public UserModel Users(@PathVariable String Userid){
		return userService.getUserbyId(Long.parseLong(Userid));
	}

	//done
	@GetMapping("/api/Users/{Userid}/tasks")
	public Set<TaskModel> Userstasks(@PathVariable String Userid){
		return userService.getUsertasksbyId(Long.parseLong(Userid));
	}
	
	//done
	@PostMapping("/api/Users")
	public List<UserModel> addUsers(@RequestBody UserModel um){
		return userService.setUser(um);
	}
	
	//done-uid injection remaining
	@PostMapping("/api/Users/{Userid}/tasks")
	public Set<TaskModel> addUserstask(@PathVariable Long Userid,@RequestBody TaskModel um){
		return userService.setUsertask(Userid,um);
	}

	//done
	@PutMapping("/api/Users/{Userid}")
	public UserModel putUser(@PathVariable Long Userid,@RequestBody UserModel um){
		return userService.putUser(Userid,um);
	}
	
	//done
	@PutMapping("/api/Users/{Userid}/{Taskid}")
	public UserModel putUsertask(@PathVariable Long Userid,@PathVariable Long Taskid,@RequestBody TaskModel um){
		return userService.putUsertask(Userid,Taskid,um);
	}
	
	//done
	@DeleteMapping("/api/Users/{Userid}")
	public List<UserModel> deleteUser(@PathVariable String Userid){
		return userService.removeUser(Long.parseLong(Userid));
	}

	//done
	@DeleteMapping("/api/Users/{Userid}/{Taskid}")
	public UserModel deleteUsertask(@PathVariable String Userid,@PathVariable String Taskid){
		return userService.removeUsertask(Long.parseLong(Userid),Long.parseLong(Taskid));
	}
	
}