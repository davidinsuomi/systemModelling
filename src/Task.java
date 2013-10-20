
public class Task {
	private String taskName;
	private int duration=0;
	private int earlyStart=0;
	private int earlyFinsh=0;
	private int lateStart=0;
	private int lateFinsh=0;
	private boolean criticalPath= false;  //default is false
	private Task[] successor;
	private Task[] predecessor;
	
	
	public boolean isCriticalPath() {
		return criticalPath;
	}
	public void setCriticalPath(boolean criticalPath) {
		this.criticalPath = criticalPath;
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
	public int getEarlyStart() {
		return earlyStart;
	}
	public void setEarlyStart(int earlyStart) {
		this.earlyStart = earlyStart;
	}
	public int getEarlyFinsh() {
		return earlyFinsh;
	}
	public void setEarlyFinsh(int earlyFinsh) {
		this.earlyFinsh = earlyFinsh;
	}
	public int getLateStart() {
		return lateStart;
	}
	public void setLateStart(int lateStart) {
		this.lateStart = lateStart;
	}
	public int getLateFinsh() {
		return lateFinsh;
	}
	public void setLateFinsh(int lateFinsh) {
		this.lateFinsh = lateFinsh;
	}
	public Task[] getSuccessor() {
		return successor;
	}
	public void setSuccessor(Task[] successor) {
		this.successor = successor;
	}
	public Task[] getPredecessor() {
		return predecessor;
	}
	public void setPredecessor(Task[] predecessor) {
		this.predecessor = predecessor;
	}
	
	
	public Task CheckTask(Task[] taskList, String taskName, int i){
		for (int j = 0; j < i; j++) {
			if(taskList[j].taskName.equals(taskName)){
				return taskList[j];
			}
		}
		return null;		
	}
	public int GetPosition(Task[] taskList, Task predecessorTask, int i){
		for (int j = 0; j < i; j++) {
			if (taskList[j].taskName.equals(predecessorTask.taskName)){
				return j;
			}
		}
		return 0;
	}
	
	public Task AddSuccessor(Task task){
		if(this.successor != null ){
			Task aux = new Task();
			aux.successor = new Task[this.successor.length+1];
			System.arraycopy(this.successor, 0, aux.successor, 0, this.successor.length);
			aux.successor[successor.length] = task;
			this.successor=aux.successor;
		}
		else{
			this.successor= new Task[1];
			this.successor[0] = task;
		}
		return this;
	}

}
