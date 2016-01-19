package mainWindow;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import componentListener.ScrollPaneListener;

import SpreadSheet.*;

public class Tp_Compilation {

	public static void main(String[] args) {

		try {  
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");  
        }
		catch (Exception e){}  
		JFrame frame = new JFrame("TP Compilation");

		/*
		 * Allows the user to exit the application from the window manager's
		 * dressing.
		 */
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		SpreadSheet sp = new SpreadSheet(31, 21);
		ToolBar _tb = new ToolBar(sp,frame);
		frame.setJMenuBar(_tb.menuBar);
		frame.getContentPane().add(_tb.toolBar, BorderLayout.NORTH);
		JTabbedPane tabbedPane = new JTabbedPane();
		_tb.saveFile(sp);
		sp.getScrollPane()
		.getVerticalScrollBar()
		.addAdjustmentListener(
				new ScrollPaneListener(sp.getScrollPane(), sp));
		sp.getScrollPane()
				.getHorizontalScrollBar()
				.addAdjustmentListener(
						new ScrollPaneListener(sp.getScrollPane(), sp));
		tabbedPane.add("Feuil1", sp.getScrollPane());
		tabbedPane.setTabPlacement(JTabbedPane.BOTTOM);

		// Panel
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		// mise en forme des objets
		panel.add(tabbedPane, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.CENTER);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(panel);
		frame.setSize(500, 250);
		frame.pack();
		frame.setVisible(true);
	}

}
