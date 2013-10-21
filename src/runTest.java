
public class runTest {



	public static void main(String[] args) {
		PertChart pertChart = new PertChart();
		pertChart.readFile("C:\\Users\\david\\Desktop\\pert.csv");	
		if(args.length ==2 ){
		pertChart.readFile(args[0]);
		pertChart.CalculateEarlyStartAndEarlyFinish();
		pertChart.CalculateLateStartAndLateFinish();
		System.out.print("Critical Path: ");
		pertChart.CalculateCriticalPath();
		pertChart.GenetateDot(args[1]);
		System.out.println("");
		}
		else{
			 System.out.print("usage java -jar myApplication.jar pert.csv(pert file name) NameOfPERTFile.pert(name of the out put)");
		}
		
	}
	


}
