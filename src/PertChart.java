import java.io.BufferedReader;
import java.io.FileReader;




public class PertChart {
	private static int MAXTASK=100;
	private int taskCount;	
	private Task[] tasks= new Task[MAXTASK];
	
	public void readFile(String fileLocation){
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileLocation));
			String line;
			taskCount=0;
			while ((line = br.readLine()) != null) {
				Task task = new Task();
				String[] lineWithoutComma = line.split(",");
				//add task name
				task.setTaskName(lineWithoutComma[0]); 
				//add duration
				task.setDuration(Integer.parseInt(lineWithoutComma[1]));
				//System.out.println(lineWithoutComma.length);
				if(lineWithoutComma.length > 2){
					task.setPredecessor(new Task[lineWithoutComma.length-2]);
					for (int i = 2; i < lineWithoutComma.length; i++) {
					Task aux = new Task();
					aux = aux.CheckTask(tasks, lineWithoutComma[i], taskCount);
					if(aux != null){
						//System.out.println("precessor name : "+aux.getTaskName());
						task.getPredecessor()[i-2] = aux;
						tasks[aux.GetPosition(tasks, aux, taskCount)] = aux.AddSuccessor(task);
					}
					else{
						 throw new Exception("file format error, no predecessor found");
					}
					
				}
				}
				tasks[taskCount] = task;
				taskCount++;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			 System.out.print("exception run");
		}
	}
	
	public void CalculateEarlyStartAndEarlyFinish(){
		tasks[0].setEarlyFinsh(tasks[0].getDuration()+tasks[0].getEarlyStart());
		for (int i = 1; i < this.taskCount; i++) {
			for( Task task : tasks[i].getPredecessor()){
				if(tasks[i].getEarlyStart() < task.getEarlyFinsh()){
					tasks[i].setEarlyStart(task.getEarlyFinsh());
				}
				tasks[i].setEarlyFinsh(tasks[i].getEarlyStart() + tasks[i].getDuration());
			}
			
		}
	}
	public void CalculateLateStartAndLateFinish(){
		tasks[taskCount -1].setLateFinsh(tasks[taskCount -1].getEarlyFinsh());
		tasks[taskCount -1].setLateStart(tasks[taskCount -1].getLateFinsh()-tasks[taskCount -1].getDuration());
		for (int i = taskCount -2 ; i >= 0 ; i--) {
			for(Task task : tasks[i].getSuccessor()){
				if(tasks[i].getLateFinsh() == 0){
					tasks[i].setLateFinsh(task.getLateStart());
				}
				else{
					if(tasks[i].getLateFinsh() > task.getLateStart()){
						tasks[i].setLateFinsh(task.getLateStart());
					}
				}
			}
			tasks[i].setLateStart(tasks[i].getLateFinsh() + tasks[i].getDuration());
		}
		
	}
	
	public void CalculateCriticalPath(){
		
		for(int i=0 ; i < taskCount ; i++){
			Task task = new Task();
			 task = tasks[i];
			if((task.getEarlyFinsh() - task.getLateFinsh() == 0)&& (task.getLateStart() - task.getEarlyStart()==0)){
				System.out.print(task.getTaskName() + " ");
			}
		}
	}
	
	
}
