package componentListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

import SpreadSheet.*;

public class openFileDialogListener implements ActionListener {

	private JFileChooser _fc;
	private SpreadSheet _sps;

	public openFileDialogListener(SpreadSheet sps) {
		_sps = sps;
	}

	public void actionPerformed(ActionEvent e) {
		_fc = new JFileChooser();
		JFrame openFileDialog = new JFrame("Open a spread sheet paper");
		FileFilter filter = new ExtensionFileFilter(
				"TPCompilationSpreadSheet(TCSS)", new String[] { "TCSS" });
		_fc.setFileFilter(filter);
		openFileDialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int returnVal = _fc.showOpenDialog(openFileDialog);
		if (returnVal == JFileChooser.APPROVE_OPTION
				&& (_fc.getFileFilter() == filter)) {
			_fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
			File file = _fc.getSelectedFile();
			try {
				FileInputStream fichier = new FileInputStream(
						file.getAbsolutePath());
				ObjectInputStream ois = new ObjectInputStream(fichier);
				_sps.readObject(ois);
				ois.close();
				_sps.repaint();
			} catch (java.io.IOException exception) {
				exception.printStackTrace();
			} catch (ClassNotFoundException eClass) {
				eClass.printStackTrace();
			}
		}

	}

}
