package componentListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.filechooser.FileFilter;

import SpreadSheet.SpreadSheet;

public class saveFileDialogListener implements ActionListener {

	private JFileChooser _fc;
	private SpreadSheet _sps;

	public saveFileDialogListener(SpreadSheet sps) {
		_sps = sps;
	}

	public void actionPerformed(ActionEvent e) {

		_fc = new JFileChooser();
		JFrame saveFileDialog = new JFrame("Save file");
		FileFilter filter = new ExtensionFileFilter(
				"TPCompilationSpreadSheet(TCSS)", new String[] { "TCSS" });
		_fc.setFileFilter(filter);
		saveFileDialog.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int returnVal = _fc.showSaveDialog(saveFileDialog);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			File file = _fc.getSelectedFile();

			try {
				FileOutputStream fichier = new FileOutputStream(
						file.getAbsolutePath() + ".TCSS");
				ObjectOutputStream oos = new ObjectOutputStream(fichier);
				_sps.writeObject(oos);
				oos.flush();
				oos.close();
			} catch (java.io.IOException exception) {
				exception.printStackTrace();
			}

		}

	}

}
