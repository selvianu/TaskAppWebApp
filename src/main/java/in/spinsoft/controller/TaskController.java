package in.spinsoft.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.spinsoft.Dao.TaskDao;
import in.spinsoft.model.Task;

@RestController
public class TaskController {

	private static Logger log = LoggerFactory.getLogger(TaskController.class);

	@Autowired
	JdbcTemplate jdbcTemplate;
	@Autowired
	TaskDao taskDao;

	@GetMapping("inserttask")
	public void saveTask(@RequestParam("taskName") String taskName, @RequestParam("createdBy") String createdBy) {
		log.info("  insert {}", taskName);

		Task t = new Task();
//		t.taskId = taskId;
		t.taskName = taskName;
		t.createdBy = createdBy;
		t.status = "PENDING";
		t.createdDate = LocalDate.now();

		System.out.println("Task Name : " + t.taskName + "status: " + t.status);
		taskDao.save(t);
	}

	@GetMapping("updatetaskstatus")
	public void update(@RequestParam("taskId") Integer taskId, @RequestParam("status") String status) {
		Task t = new Task();
		t.taskId = taskId;
		t.status = status;
		System.out.println("Task Status update : " + t.status);
		taskDao.update(t);

	}

	@GetMapping("deletetask")
	public void delete(@RequestParam("taskId") Integer taskId) {
		Task t = new Task();
		t.taskId = taskId;
		t.status = "inactive";
		System.out.println("Task Status update : " + t.status);
		taskDao.delete(t);
	}

	@GetMapping("listoftask")
	public List<Task> listOfTask() {
		System.out.println("getting all task");
		List<Task> taskList = taskDao.taskList();
		return taskList;

	}

	@GetMapping("findbytaskid")
	public List<Task> findTaskById(@RequestParam("taskId") Integer taskId) {
		System.out.println("getting task by Id");
		Task t = new Task();
		t.taskId = taskId;
		List<Task> findByTaskId = taskDao.findByTaskId(t);
		System.out.println(t.taskName);
		return findByTaskId;

	}

	@GetMapping("findpendingtask")
	public List<Task> findPendingTask(@RequestParam("") Integer taskId) {
		System.out.println("getting task by Id");
		Task t = new Task();
		t.taskId = taskId;
		List<Task> findByTaskId = taskDao.findByTaskId(t);
		System.out.println(t.taskName);
		return findByTaskId;

	}
}
