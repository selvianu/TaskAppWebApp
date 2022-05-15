package in.spinsoft.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import in.spinsoft.mapper.UserMapper;
import in.spinsoft.model.Users;

@Repository
public class UserDao {
	@Autowired
	JdbcTemplate jdbcTemplate;

	public void save(Users u1) {
		String sql = "insert into task_users( user_name,password,email) values (?,?,?)";
		Object[] params = { u1.userName, u1.password, u1.email };
		int noOfRows = jdbcTemplate.update(sql, params);

	}

	public void save1(Users u1) {
		String sql = "insert into task_users(user_id, user_name,password,email) values (?,?,?,?)";
		Object[] params = { u1.userId, u1.userName, u1.password, u1.email };
		int noOfRows = jdbcTemplate.update(sql, params);
	}

	public void delete(Users u1) {
		String sql = "delete from task_users where user_id=?";
		Object[] params = { u1.userId };
		int noOfRowsDeleted = jdbcTemplate.update(sql, params);
		System.out.println("noOfRowsDeleted : " + noOfRowsDeleted);

	}

	public void update(Users u1) {
		String sql = "update task_users set password=? where user_id=?";
		Object[] params = { u1.password, u1.userId };
		int noOfRows = jdbcTemplate.update(sql, params);
		System.out.println("noOfRowsUpdated : " + noOfRows);

	}

	public List<Users> listUsers() {
		String sql = "select * from task_users";
		System.out.println(sql);
		List<Users> usersList = jdbcTemplate.query(sql, new UserMapper());
		System.out.println(usersList);
		return usersList;
	}

}
