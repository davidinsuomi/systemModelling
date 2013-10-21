
public class runTest {



	public static void main(String[] args) {
		PertChart pertChart = new PertChart();
		//pertChart.readFile("F:\\Dropbox\\tartu\\modeling\\pert.csv");	
		if(args.length ==1 ){
		pertChart.readFile(args[0]);
		pertChart.CalculateEarlyStartAndEarlyFinish();
		pertChart.CalculateLateStartAndLateFinish();
		System.out.print("Critical Path: ");
		pertChart.CalculateCriticalPath();
		pertChart.GenetateDot();
		System.out.println("");
		}
		else{
			 System.out.print("usage java -jar myApplication.jar pert.csv(pert file name) ");
		}
		
	}
	


}
