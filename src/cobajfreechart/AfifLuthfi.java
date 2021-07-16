package cobajfreechart;


import java.awt.Color;
import java.awt.GradientPaint;
import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.StandardBarPainter;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class AfifLuthfi extends ApplicationFrame {

    private static final long serialVersionUID = -1314877738034042129L;

    private Dataset dataset;
    private AfifLuthfiController afifLuthfiController;
    private String title;
    
    
    public AfifLuthfi(final String title, String query) {
        
        super(title);
        this.title = title;
        
        afifLuthfiController = new AfifLuthfiController();
        dataset = afifLuthfiController.getDataset(query);
        
        final JFreeChart chart = createChart(createDataset());

        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(1000, 500)); // merubah dimensi chart (width, height)
        setContentPane(chartPanel);
        
        addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent evt) {
                dispose();
            }
        });
        
        setUndecorated(true); // untuk mematikan exit, maximize, minimize
        setExtendedState(JFrame.MAXIMIZED_BOTH);  // untuk full screen
        
        this.pack();
        RefineryUtilities.centerFrameOnScreen(this);
        
        this.setVisible(true);
    }

    private CategoryDataset createDataset() {
        
        DefaultCategoryDataset deafultCategoryDataset = new DefaultCategoryDataset();
                                        // jumlah, retur/terjual, nama barang
                                        // x sebagai retur
                                        // y sebagai terjual
        int jumlahData = dataset.getJumlahData();
        for(int i = 0; i < jumlahData; i++) {
            deafultCategoryDataset.setValue(dataset.getRetur(i), "Retur", dataset.getNamaBarang(i));
            deafultCategoryDataset.setValue(dataset.getTerjual(i), "Terjual", dataset.getNamaBarang(i));
        }
        
        return deafultCategoryDataset;
    }

    private JFreeChart createChart(CategoryDataset dataset) {
        //JFreeChart chart = ChartFactory.createXYLineChart("title", "xAxisLabel", "yAxisLabel", dataset, PlotOrientation.VERTICAL, true, true, true);

        JFreeChart chart = ChartFactory.createBarChart(title, "Nama Barang", "Jumlah", dataset, PlotOrientation.VERTICAL, true, true, true);

        CategoryPlot plot = chart.getCategoryPlot();

        //plot.setRangeCrosshairPaint(Color.RED);
        //plot.setDomainGridlinePaint(Color.RED);
        plot.setRangeGridlinePaint(Color.BLACK);

        plot.setBackgroundPaint(Color.WHITE);

        plot.setOutlineVisible(false);

        BarRenderer renderer = (BarRenderer) plot.getRenderer();

        renderer.setGradientPaintTransformer(null);

        
        GradientPaint gp1 = new GradientPaint(
                7, 7, Color.BLUE,
                2, 2, Color.BLACK,
                true
        );
        //renderer.setSeriesPaint(0, gp1);

        renderer.setSeriesFillPaint(0, gp1);
        renderer.setBarPainter(new StandardBarPainter());

        //plot.setRangeGridlinePaint(gp1);
        /*Point2D start = new Point2D.Float(10, 5);
        Point2D end = new Point2D.Float(5, 10);
        float[] dist = {0.2f, 0.4f, 0.6f};
        Color[] colors = {Color.RED, Color.YELLOW, Color.RED};
        LinearGradientPaint p = new LinearGradientPaint(start, end, dist, colors);
        renderer.setSeriesPaint(0, p);*/
        //chart.getXYPlot().setDomainGridlinePaint(Color.RED);
        return chart;
    }
}
