package in.spinsoft.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.spinsoft.model.Users;

public class UserMapper implements RowMapper<Users> {

	@Override
	public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
		Users user = new Users();
		user.userId = rs.getInt("user_id");
		user.userName = rs.getString("user_name");
		user.email = rs.getString("email");
		return user;
	}

}