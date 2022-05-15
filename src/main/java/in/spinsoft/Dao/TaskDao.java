package in.spinsoft.Dao;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import in.spinsoft.mapper.TaskMapper;
import in.spinsoft.mapper.UserMapper;
import in.spinsoft.model.Task;

@Repository
public class TaskDao {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public void save(Task t) {
		String sql = "insert into task(task_name, created_by, status, created_date) values (?,?,?,?)";
		Date cdate = Date.valueOf(t.createdDate);
		System.out.println(t.createdBy);
		Object[] params = { t.taskName, t.createdBy, t.status, cdate };
		int noOfRows = jdbcTemplate.update(sql, params);

		System.out.println(noOfRows);
	}

	public void update(Task t) {
		String sql = "update task set status=? where task_id=?";
		Object[] params = { t.status, t.taskId };
		int noOfRowsUpdated = jdbcTemplate.update(sql, params);
		System.out.println("noOfRowsUpdated : " + noOfRowsUpdated);
	}

	public void delete(Task t) {
		String sql = "update task set status=? where task_id=?";
		Object[] params = { t.status, t.taskId };
		int noOfRowsUpdated = jdbcTemplate.update(sql, params);
		System.out.println("noOfRowsUpdated : " + noOfRowsUpdated);
	}

	public List<Task> taskList() {
		String sql = "select * from task";
		List<Task> taskList = jdbcTemplate.query(sql, new TaskMapper());
		System.out.println(taskList);
		return taskList;
	}

	public List<Task> findByTaskId(Task t) {
		Object[] params = { t.taskId };
		System.out.println(params);
		return jdbcTemplate.query("select * from task where task_id = ?", new TaskMapper(), t.taskId);
	}
}
