package mainWindow;

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import SpreadSheet.*;
import componentListener.*;

public class TpCompilation {

	static ArrayList<SpreadSheet> arrList = new ArrayList<SpreadSheet>();

	public static int _cptSheet = 0;
	public static ImageIcon _addIcon = new ImageIcon(
			"C:\\Users\\hoc\\workspace\\JTabbedPane\\Images\\add.png");

	public static void ajouterLOnglet(JTabbedPane onglet, String texte) {
		SpreadSheet sp = new SpreadSheet(31, 21);
		arrList.add(sp);
		onglet.add(texte, sp.getScrollPane());
		onglet.setTabPlacement(JTabbedPane.BOTTOM);
		// ScrollPane Listener
		/*
		 * sp.getScrollPane().getVerticalScrollBar().addAdjustmentListener( new
		 * ScrollPaneListener( sp.getScrollPane() , sp));
		 */
		sp.getScrollPane()
				.getHorizontalScrollBar()
				.addAdjustmentListener(
						new ScrollPaneListener(sp.getScrollPane(), sp));
	}

	static void ajouterLOnglet_Icone(JTabbedPane onglet, JPanel _pnlAdd) {
		onglet.addTab("", _addIcon, _pnlAdd, "Ajouter une feuille");
		onglet.setTabPlacement(JTabbedPane.BOTTOM);

	}

	public static void main(String[] args) {

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

		JPanel _pnlAdd = new JPanel();

		JTabbedPane tabbedPane = new JTabbedPane();
		_cptSheet++;
		ajouterLOnglet(tabbedPane, "Feuil" + Integer.toString(_cptSheet));
		_cptSheet++;
		ajouterLOnglet(tabbedPane, "Feuil" + Integer.toString(_cptSheet));
		_cptSheet++;
		ajouterLOnglet(tabbedPane, "Feuil" + Integer.toString(_cptSheet));

		// Panel add new SpreadSheet
		ajouterLOnglet_Icone(tabbedPane, _pnlAdd);
		tabbedPane.addChangeListener(new SpreadSheetListener(tabbedPane,
				_pnlAdd));

		/*ToolBar _tb = new ToolBar(sp);
		_tb.pane = new JTextPane();
		_tb.pane.setPreferredSize(new Dimension(250, 250));
		_tb.pane.setBorder(new BevelBorder(BevelBorder.LOWERED));
		_tb.toolBar.setMaximumSize(_tb.toolBar.getSize());
		frame.setJMenuBar(_tb.menuBar);
		frame.getContentPane().add(_tb.toolBar, BorderLayout.NORTH);
		frame.getContentPane().add(_tb.pane, BorderLayout.CENTER);
*/
		// Panel
		JPanel panel2 = new JPanel();
		panel2.setLayout(new BorderLayout());
		// mise en forme des objets
		panel2.add(tabbedPane, BorderLayout.CENTER);
		frame.add(panel2, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(100, 150);
		frame.pack();
		frame.setVisible(true);
	}

}
