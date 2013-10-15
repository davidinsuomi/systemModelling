
public class runTest {



	public static void main(String[] args) {
		PertChart pert = new PertChart();
		pert.parseFile("F:\\Dropbox\\tartu\\modeling\\successor.csv");
		//pert.printChart();
		pert.generateDot( );
	}
	


}
