package myMath;

import java.awt.Graphics2D;
import java.util.ArrayList;

import org.knowm.xchart.QuickChart;
import org.knowm.xchart.SwingWrapper;
import org.knowm.xchart.XYChart;
import org.knowm.xchart.XYChartBuilder;
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
    String[] label = new String[81];
	for (double x=-2 ;x<=6;x+=0.1) {
		xData[Index] = x;
		yData[Index++] = pol.f(x);
		//label[Index++] = 1;
	}
	
	//calculate the kitzon points
	Polynom DevPol = (Polynom)(pol.derivative());
	String kitzon="kitzon point: ";
	for (double x=-2 ;x<6;x+=1) {
		if ((DevPol.f(x)*DevPol.f(x+1))<0) {
			double XValueKitzon = DevPol.root(x, x+1, 0.00001);
			double YValueKitzon = pol.f(XValueKitzon);
			XValueKitzon = (double)((int)(XValueKitzon*1000))/1000;
			YValueKitzon = (double)((int)(YValueKitzon*1000))/1000;
			kitzon=kitzon+"("+XValueKitzon+","+YValueKitzon+"),  ";
			
		}
	}
	kitzon = kitzon.substring(0, kitzon.length()-3);
	//calculate the erea betwen the graph and axis x
	double rymanSum=0;
	double eps = 0.01;
	double x0=-2;
	while (x0<6) {
		if ((pol.f(x0)*eps)<0)
			rymanSum += pol.f(x0)*eps;
		x0+=eps;
	}
	System.err.println("the sum between the graph and axis x is: "+rymanSum*-1);
	
    // Create Chart
    XYChart chart = QuickChart.getChart(kitzon, "X", "Y", "y(x)", xData, yData);
    //XYChart chart = new XYChartBuilder().build();
    
    //XYSeries series = chart.addSeries("demo", xData, yData, label);
   // XYSeries series = chart.addSeries("hjhj", xData, yData);
   // series.setToolTips();
   // chart.getStyler().setToolTipsEnabled(true);
    
    // Show it
    new SwingWrapper(chart).displayChart();
 
  }
}
