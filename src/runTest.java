
public class runTest {



	public static void main(String[] args) {
		PertChart pert = new PertChart();
		pert.readFile("F:\\Dropbox\\tartu\\modeling\\successor.csv");
		//pert.printChart();
		pert.generateDot( );
	}
	


}
