import java.util.ArrayList;
import java.util.List;


public class Task {
	
	private String taskName;
	
	private int duration;
	
	private List<String> precedenceTaskName;
	public Task(){
		this.taskName=null;
		this.duration=0;
		this.precedenceTaskName = new ArrayList<>();	
	}
	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public List<String> getPrecedenceTaskName() {
		return precedenceTaskName;
	}

	public void setPrecedenceTaskName(List<String> precedenceTaskName) {
		this.precedenceTaskName = precedenceTaskName;
	}


}
