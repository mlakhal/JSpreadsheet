package componentListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import mainWindow.TpCompilation;

public class SpreadSheetListener implements ChangeListener {

	private JTabbedPane onglet;
	private JPanel _pnl;

	public SpreadSheetListener(JTabbedPane _jtp, JPanel _pnlAdd) {
		onglet = _jtp;
		_pnl = _pnlAdd;
	}

	public void stateChanged(ChangeEvent changeEvent) {
		JTabbedPane sourceTabbedPane = (JTabbedPane) changeEvent.getSource();
		int index = sourceTabbedPane.getSelectedIndex();
		if (index == TpCompilation._cptSheet) {
			int _index = onglet.indexOfComponent(_pnl);
			onglet.removeTabAt(_index);
			TpCompilation._cptSheet++;
			TpCompilation.ajouterLOnglet(onglet,
					"Feuil" + Integer.toString(TpCompilation._cptSheet));
			onglet.addTab("", TpCompilation._addIcon, _pnl);
		}
	}

}