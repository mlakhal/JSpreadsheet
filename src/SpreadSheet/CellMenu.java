package SpreadSheet;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
class CellMenu extends JPopupMenu implements ActionListener {

	static private final String _FOREGROUND = "Foreground";
	static private final String _BACKGROUND = "Background";
	@SuppressWarnings("unused")
	static private final String _FONT = "Font";
	@SuppressWarnings("unused")
	static private final String _EDITABLE = "Editable";

	private Object _targetCells[];
	private JWindow _colorWindow;
	private SpreadSheet _sp;

	CellMenu(SpreadSheet parent) {

		_sp = parent;

		setDefaultLightWeightPopupEnabled(true);

		JMenuItem item = new JMenuItem(_FOREGROUND);
		item.addActionListener(this);
		add(item);
		item = new JMenuItem(_BACKGROUND);
		item.addActionListener(this);
		add(item);
		pack();
	}

	void setTargetCells(Object c[]) {
		_targetCells = c;
	}

	public void actionPerformed(ActionEvent ev) {

		if (ev.getActionCommand().equals(_FOREGROUND)) {
			setVisible(false);
			if (_colorWindow == null)
				new JWindow();
			Color col = JColorChooser.showDialog(_colorWindow,
					"Foreground Color", null);
			for (int ii = 0; ii < _targetCells.length; ii++) {
				SheetCell sc = (SheetCell) _targetCells[ii];
				sc.foreground = col;
			}
			_sp.repaint();
		} else if (ev.getActionCommand().equals(_BACKGROUND)) {
			setVisible(false);
			if (_colorWindow == null)
				new JWindow();
			Color col = JColorChooser.showDialog(_colorWindow,
					"Background Color", null);
			for (int ii = 0; ii < _targetCells.length; ii++) {
				SheetCell sc = (SheetCell) _targetCells[ii];
				sc.background = col;
			}
			_sp.repaint();
		}

	}

}