package myMath;

<<<<<<< HEAD
//import java.awt.Graphics2D;
//import java.util.ArrayList;
=======
import java.awt.Graphics2D;
import java.util.ArrayList;
>>>>>>> refs/heads/polynom_add_plot
import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
//import org.knowm.xchart.XYChartBuilder;
import org.knowm.xchart.XYSeries;

/**
 * Creates a simple Chart using QuickChart
 */
public class Plot1 {
 
  public static void main(String[] args) throws Exception {
    Polynom pol = new Polynom("0.2*x^4-1.5*x^3+3*x^2-1*x^1-5*x^0");
    
    //calculate the graph points
    int Index=0;
    double[] xData = new double[81];
    double[] yData = new double[81];

    
	for (double x=-2 ;x<=6;x+=0.1) {
		xData[Index] = x;
		yData[Index++] = pol.f(x);
		
	}
	//calculate the erea betwen the graph and axis x
	double rymanSum=0;
	double eps = 0.01;
	double x0=-2;
	while (x0<6) {
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
	for (double x=-2 ;x<6;x+=0.1) {
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
