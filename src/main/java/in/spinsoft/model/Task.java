package in.spinsoft.model;

import java.sql.Date;
import java.time.LocalDate;

public class Task {

	public int taskId;
	public String taskName;
	public String createdBy;
	public LocalDate createdDate;
	public String status;

	@Override
	public String toString() {
		return "Task [taskId=" + taskId + ", taskName=" + taskName + ", createdBy=" + createdBy + ", createdDate="
				+ createdDate + ", status=" + status + "]";
	}

}
