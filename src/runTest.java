
public class runTest {



	public static void main(String[] args) {
		PertChart pertChart = new PertChart();
		pertChart.readFile("F:\\Dropbox\\tartu\\modeling\\pert.csv");
		pertChart.CalculateEarlyStartAndEarlyFinish();
		pertChart.CalculateLateStartAndLateFinish();
		System.out.print("Critical Path: ");
		pertChart.CalculateCriticalPath();
		pertChart.GenetateDot();
		System.out.println("");
	}
	


}
