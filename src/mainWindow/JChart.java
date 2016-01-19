package mainWindow;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;


public class JChart extends JFrame {

  private static final long serialVersionUID = 1L;

  public JChart(String applicationTitle, String chartTitle , DefaultCategoryDataset dataSet) {
        super(applicationTitle);
        // This will create the dataset 
        DefaultCategoryDataset dataset = dataSet;
        // based on the dataset we create the chart
        JFreeChart chart = createChart(dataset, chartTitle);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        // default size
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
        // add it to our application
        setContentPane(chartPanel);

    }    
    
/**
     * Creates a chart
     */

    private JFreeChart createChart(CategoryDataset dataset, String title) {
        
    	JFreeChart chart = ChartFactory.createBarChart3D( "Comparison", 
    			"Data", "Value", dataset, PlotOrientation.VERTICAL, true, true, false );
        return chart;
        
    }
    
} 

   