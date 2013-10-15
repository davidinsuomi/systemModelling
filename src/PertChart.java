import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;


public class PertChart {
	private List<Task> taskList;
	
	PertChart(){
		taskList  = new ArrayList<>();
	}
	public void calculateCriticalPath()
	{
		
	}
	
	public void parseFile(String fileLocation)
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileLocation));
			String line;
			while ((line = br.readLine()) != null) {
				Task task = new Task();
				String[] lineWithoutComma = line.split(",");
				//add task name
				task.setTaskName(lineWithoutComma[0]); 
				//add duration
				task.setDuration(Integer.parseInt(lineWithoutComma[1]));
				if(lineWithoutComma.length > 2){
					List<String> precedenceTaskName = new ArrayList<>();
					for (int i = 2; i < lineWithoutComma.length; i++) {
						precedenceTaskName.add(lineWithoutComma[i]);
					}
				task.setPrecedenceTaskName(precedenceTaskName);
				}
	
			taskList.add(task);
			}
			br.close();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print("exception run");
		}
	}
	
	public void generateDot( )
	{
		String fileLocation = "F:\\Dropbox\\tartu\\modeling\\pertchart.dot";
		PrintStream out = null;
		try {
			out = new PrintStream(new FileOutputStream(fileLocation));
		    out.print("digraph myPERT {");
		    for (Task task : taskList) {
		    	String format= task.getTaskName() + "[shape=polygon, sides=4, style=\"bold\", color=\"black\",label=\"" + task.getTaskName()+"(" + task.getDuration() +" days)\"]";
		    	out.println(format);
		    	
			}
		    for (Task task : taskList) {
				if(task.getPrecedenceTaskName().isEmpty()==false){
					for (int i = 0; i < task.getPrecedenceTaskName().size(); i++) {
						String format = task.getTaskName() +"->" + task.getPrecedenceTaskName().get(i) +"[label=\"\"]" ;
						out.println(format);
					}
				}

			}
		    out.println("}");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
		    if (out != null) out.close();
		}
	}
	public void printChart(){
		for (Task task : taskList) {
			System.out.print(task.getTaskName());
			System.out.print(task.getDuration());
			System.out.println("");
		}
		
	}
}
