
public class runTest {



	public static void main(String[] args) {
		PertChart pertChart = new PertChart();
		pertChart.readFile("F:\\Dropbox\\tartu\\modeling\\pert.csv");
		pertChart.CalculateEarlyStartAndEarlyFinish();
		pertChart.CalculateLateStartAndLateFinish();
		pertChart.CalculateCriticalPath();
		System.out.print("");
	}
	


}
