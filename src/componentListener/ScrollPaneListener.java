package componentListener;

import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

import javax.swing.JScrollPane;
import javax.swing.JViewport;

import SpreadSheet.*;

public class ScrollPaneListener implements AdjustmentListener {

	private JScrollPane _scr;
	private SpreadSheet _sp;

	public ScrollPaneListener(JScrollPane _scrSpreadSheet, SpreadSheet _spCol) {
		_scr = _scrSpreadSheet;
		_sp = _spCol;
	}

	public void adjustmentValueChanged(AdjustmentEvent e) {
		JViewport vp = _scr.getViewport();
		if (vp.getView().getHeight() == vp.getHeight() + vp.getViewPosition().y) {
			_sp.addRow();
		}

		if (vp.getView().getWidth() == vp.getWidth() + vp.getViewPosition().x) {
			_sp.addNewColumn();
		}

	}

}
