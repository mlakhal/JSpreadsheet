package chartPackage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import SpreadSheet.SpreadSheet;

@SuppressWarnings("serial")
public class chartMenu extends JPopupMenu implements ActionListener {

	static private final String _barChart = "Bar chart";
	static private final String _pieChart = "Pie chart";
	static private final String _pieChart3D = "Pie chart 3D";
	private SpreadSheet _sp;

	public chartMenu(SpreadSheet parent) {

		_sp = parent;

		setDefaultLightWeightPopupEnabled(true);

		JMenuItem item = new JMenuItem(_barChart);
		item.addActionListener(this);
		add(item);
		item = new JMenuItem(_pieChart);
		item.addActionListener(this);
		add(item);
		item = new JMenuItem(_pieChart3D);
		item.addActionListener(this);
		add(item);
		pack();
	}

	public void actionPerformed(ActionEvent ev) {
		if (ev.getActionCommand().equals(_barChart)) {
		
			_sp.repaint();
		}
	}

}
