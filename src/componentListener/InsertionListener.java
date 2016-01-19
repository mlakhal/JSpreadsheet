package componentListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class InsertionListener implements MouseListener {

	private JPanel _pnlDiagrammes, _pnlInsertion;

	public InsertionListener(JPanel _pnlDiagrammes, JPanel _pnlInsertion) {
		this._pnlDiagrammes = _pnlDiagrammes;
		this._pnlInsertion = _pnlInsertion;
	}

	public void mouseClicked(MouseEvent arg0) {
		_pnlInsertion.setVisible(true);
		_pnlDiagrammes.setVisible(false);
	}

	public void mouseEntered(MouseEvent arg0) {

	}

	public void mouseExited(MouseEvent arg0) {

	}

	public void mousePressed(MouseEvent arg0) {

	}

	public void mouseReleased(MouseEvent arg0) {

	}

}
