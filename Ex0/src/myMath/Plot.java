package myMath;
//all of those class imported from xchart project https://github.com/knowm/XChart.git
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import java.util.Scanner;


/**
 * Creates a simple Chart using QuickChart
 */
public class Plot {
 
  public static void main(String[] args) throws Exception {
	System.out.println("enter the polynom");
	Scanner p = new Scanner(System.in);
    Polynom pol = new Polynom(p.nextLine());
    System.out.println("enter the left range in integer");
    int l = p.nextInt();
    System.out.println("enter the right range in integer");
    int r = p.nextInt();
    //calculate the graph points
    int Index=0;
    double[] xData = new double[1+((r-l)*10)];
    double[] yData = new double[1+((r-l)*10)];

    
	for (double x=l ;x<=r;x+=0.1) {
		xData[Index] = x;
		yData[Index++] = pol.f(x);
		
	}
	//calculate the erea betwen the graph and axis x
	double rymanSum=0;
	double eps = 0.01;
	double x0=l;
	while (x0<r) {
		if ((pol.f(x0)*eps)<0)
			rymanSum += pol.f(x0)*eps;
		x0+=eps;
	}
	rymanSum = (double)((int)(rymanSum/0.001))/1000;
	System.err.println("the erea above the graph and benith axis x is: "+rymanSum*-1);
	// Create Chart
	
    XYChart chart = QuickChart.getChart("the erea above the graph and benith axis x is: "+rymanSum*-1, "X", "Y", "y(x)", xData, yData);
	
	Polynom DevPol = (Polynom)(pol.derivative());
	
	Index=0;
	for (double x=l ;x<r;x+=0.1) {
		if ((DevPol.f(x)*DevPol.f(x+0.1))<0) {
			double XValueKitzon = DevPol.root(x, x+0.1, 0.00001);
			double YValueKitzon = pol.f(XValueKitzon);
			XValueKitzon = (double)((int)(XValueKitzon*1000))/1000;
			YValueKitzon = (double)((int)(YValueKitzon*1000))/1000;
		    double[] KxData = {XValueKitzon};
		    double[] KyData = {YValueKitzon};
		    chart.addSeries("("+XValueKitzon+","+ YValueKitzon+")", KxData, KyData);
		}
		
	}
   
    // Show it
    new SwingWrapper(chart).displayChart();

  }
}
