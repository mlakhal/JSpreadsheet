package componentListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import mainWindow.JChart;

import org.jfree.data.category.DefaultCategoryDataset;

import SpreadSheet.*;

public class chartListener implements ActionListener {
	private SpreadSheet _sps;
	private DefaultCategoryDataset result;

	public chartListener(SpreadSheet sps) {
		_sps = sps;
	}

	public boolean isEmptyColumn(int col) {
		int selRow[] = _sps.getSelectedRows();
		int selCol[] = _sps.getSelectedColumns();
		for (int i = 0; i < selRow.length; i++) {
			for (int j = 0; j < selCol.length; j++) {
				if (j == col) {
					SheetCell cell = (SheetCell) _sps.getValueAt(selRow[i],
							selCol[j]);
					String value = (String) cell.getValue();
					if (value != null) {
						return false;
					}
				}
			}
		}
		return true;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		int selRow[] = _sps.getSelectedRows();
		int selCol[] = _sps.getSelectedColumns();
		result = new DefaultCategoryDataset();
		for (int i = 0; i < selRow.length; i++) {
			for (int j = 0; j < selCol.length; j++) {
				if (!isEmptyColumn(j)) {
					SheetCell cell = (SheetCell) _sps.getValueAt(selRow[i],
							selCol[j]);
					int value = 0;
					try {
						value = Integer.parseInt((String) cell.getValue());
					} catch (Exception e) {
					}
					String categorie = "Categorie " + (j + 1);
					String column = Integer.toString(i + 1);
					result.setValue(value, categorie, column);
				}
			}
		}
		JChart frame = new JChart("Comparison", "Comparaison between data",
				result);
		frame.setBounds(200, 200, 600, 400);
		frame.setVisible(true);
	}
}
