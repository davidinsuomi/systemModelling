
public class runTest {



	public static void main(String[] args) {
		PertChart pertChart = new PertChart();
		
		//String input = "C:\\Users\\david\\Desktop\\123.csv";
		//String output = "C:\\Users\\david\\Desktop\\out.pert";
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
			 System.out.println("usage:");
			 System.out.print("java -jar myApplication.jar pert.csv(pert file name) NameOfPERTFile.pert(name of the out put)");
		}
		
	}
	


}
