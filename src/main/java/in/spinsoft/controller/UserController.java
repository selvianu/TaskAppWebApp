package in.spinsoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.spinsoft.Dao.UserDao;
import in.spinsoft.model.Users;

@RestController
public class UserController {
	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	UserDao userDao;

	@GetMapping("/register1")
	public void registerOne(@RequestParam("userName") String userName, @RequestParam("password") String password,
			@RequestParam("email") String email) {
		Users u1 = new Users();
		u1.userName = userName;
		u1.password = password;
		u1.email = email;
		System.out.println("User Id : " + u1.userId + "User Name: " + u1.userName);
		userDao.save1(u1);
	}

	@GetMapping("delete")
	public void delete(@RequestParam("userid") Integer userId) {
		Users u1 = new Users();
		u1.userId = userId;
		System.out.println(u1);
		userDao.delete(u1);

	}

	@GetMapping("update")
	public void update(@RequestParam("userid") Integer userId, @RequestParam("password") String password) {
		Users u1 = new Users();
		u1.userId = userId;
		u1.password = password;
		System.out.println(u1);
		userDao.update(u1);
	}

	@GetMapping("listofusers")
	public List<Users> getAllUsers() {
		System.out.println("getting datas");
		List<Users> listUsers = userDao.listUsers();
		return listUsers;

	}
}
