package componentListener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

public class DiagramListener implements MouseListener {

	private JPanel _pnlDiagrammes, _pnlInsertion;

	public DiagramListener(JPanel _pnlDiagrammes, JPanel _pnlInsertion) {
		this._pnlDiagrammes = _pnlDiagrammes;
		this._pnlInsertion = _pnlInsertion;
	}

	public void mouseClicked(MouseEvent e) {
		_pnlDiagrammes.setVisible(true);
		_pnlInsertion.setVisible(false);
	}

	public void mouseEntered(MouseEvent e) {

	}

	public void mouseExited(MouseEvent e) {

	}

	public void mousePressed(MouseEvent e) {

	}

	public void mouseReleased(MouseEvent e) {

	}

}
