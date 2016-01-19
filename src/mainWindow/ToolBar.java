package mainWindow;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import componentListener.*;
import SpreadSheet.*;
import componentListener.saveFileDialogListener;
import componentListener.openFileDialogListener;
import componentListener.closeWindowListener;
import componentListener.JTextField_Listener;

@SuppressWarnings("serial")
public class ToolBar extends JPanel {

	public JTextField jtf;
	public JPanel _pnlInsertion, _pnlDiagrammes;
	public JTextPane pane;
	public JMenuBar menuBar;
	public JToolBar toolBar;
	public JMenu file;
	private JMenu _info ;
	public JMenuItem _app;
	private JMenuItem enregistrer;
	public JMenuItem ouvrir;
	public JMenuItem fermer;
	public JButton _btnPieChart, _btnPieChart3D, _btnDualAxis;
	private SpreadSheet _sps;
	private JFrame _frame;
	private JLabel _jtfLabel;
	private JComboBox _combo;
	private String[] _fonction = { "somme(arg1;...;argk)",
			"produit(arg1;...;argk)", "moyenne(arg1;...;argk)", "sin(x)",
			"cos(x)", "tan(x)", "log(x)", "ln(x)", "puissance(a;b)", "rac(x)",
			"abs(x)", "var(arg1;...;argk)", "esperance(arg1;...;argk)",
			"min(arg1;...;argk)", "max(arg1;...;argk)",
			"ecartType(arg1;...;argk)", "and(arg1;...;argk)",
			"or(arg1;...;argk)", "not(x)", "si((exp);a;b)" };

	public ToolBar(SpreadSheet sps, JFrame frame) {
		_frame = frame;
		_sps = sps;
		menuBar = new JMenuBar();
		// Add a JMenu
		file = new JMenu("Fichier");
		_info = new JMenu("Aide");
		enregistrer = new JMenuItem("Enregistrer");
		enregistrer.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_S, java.awt.Event.CTRL_MASK));
		enregistrer
				.setIcon(new ImageIcon(
						"C:\\Users\\hoc\\workspace\\TableT\\src\\mainWindow\\Images\\save-file.png"));
		ouvrir = new JMenuItem("Ouvrir");
		ouvrir.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_O, java.awt.Event.CTRL_MASK));
		ouvrir.setIcon(new ImageIcon(
				"C:\\Users\\hoc\\workspace\\TableT\\src\\mainWindow\\Images\\open-file.png"));
		ouvrir.addActionListener(new openFileDialogListener(_sps));
		fermer = new JMenuItem("Fermer");
		fermer.addActionListener(new closeWindowListener(_frame));
		fermer.setAccelerator(KeyStroke.getKeyStroke(
				java.awt.event.KeyEvent.VK_F4, java.awt.Event.ALT_MASK));
		fermer.setPreferredSize(new Dimension(100, 30));
		file.add(enregistrer);
		file.add(ouvrir);
		file.add(fermer);
		JMenu insertion = new JMenu("Insertion");
		JMenu diagrammes = new JMenu("Diagrammes");
		menuBar.add(file);
		menuBar.add(insertion);
		menuBar.add(diagrammes);
		menuBar.add(_info);
		jtf = new JTextField("");
		_jtfLabel = new JLabel("f(x) = ");
		_app = new JMenuItem("A propos");
		_info.add(_app);
		_app.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				JFrame _frame = new JFrame("Erreur");
		        JOptionPane.showMessageDialog(_frame, "TP compilation réalisé par: Lakhal Mohamed Ilyes\n Groupe: B1 2CS\n Année :2013/2014",
						      "Mini Excel",
						      JOptionPane.QUESTION_MESSAGE);
			}
		});
		_combo = new JComboBox(_fonction);
		_combo.setPreferredSize(new Dimension(150, 20));
		_combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				switch(_combo.getSelectedIndex()){
				case 0:
					jtf.setText("somme(arg1;...;argk)");
					break;
				case 1:
					jtf.setText("produit(arg1;...;argk)");
					break;
				case 2:
					jtf.setText("moyenne(arg1;...;argk)");
					break;
				case 3:
					jtf.setText("sin(x)");
					break;
				case 4:
					jtf.setText("cos(x)");
					break;
				case 5:
					jtf.setText("tan(x)");
					break;
				case 6:
					jtf.setText("log(x)");
					break;
				case 7:
					jtf.setText("ln(x)");
					break;
				case 8:
					jtf.setText("puissance(a;b)");
					break;
				case 9:
					jtf.setText("rac(x)");
					break;
				case 10:
					jtf.setText("abs(x)");
					break;
				case 11:
					jtf.setText("var(arg1;...;argk)");
					break;
				case 12:
					jtf.setText("esperance(arg1;...;argk)");
					break;
				case 13:
					jtf.setText("min(arg1;...;argk)");
					break;
				case 14:
					jtf.setText("max(arg1;...;argk)");
					break;
				case 15:
					jtf.setText("ecartType(arg1;...;argk)");
					break;
				case 16:
					jtf.setText("and(arg1;...;argk)");
					break;
				case 17:
					jtf.setText("or(arg1;...;argk)");
					break;
				case 18:
					jtf.setText("not(x)");
					break;
				case 19:
					jtf.setText("si((exp);a;b)");
					break;
				}

			}
		});
		_sps._jtf = jtf;
		jtf.setPreferredSize(new Dimension(150, 30));
		jtf.addKeyListener(new JTextField_Listener(jtf, _sps));
		toolBar = new JToolBar("Formatting");
		_pnlInsertion = new JPanel();
		_pnlInsertion.setLayout(new BorderLayout());
		_pnlInsertion.add(_jtfLabel, BorderLayout.WEST);
		_pnlInsertion.add(_combo, BorderLayout.SOUTH);
		_pnlInsertion.add(jtf, BorderLayout.CENTER);
		_pnlInsertion.setPreferredSize(new Dimension(50, 61));
		toolBar.add(_pnlInsertion);
		_pnlDiagrammes = new JPanel();
		_pnlInsertion.setLayout(new FlowLayout());

		_btnPieChart = new JButton();
		_btnPieChart.setIcon(new ImageIcon(
				"C:\\Users\\hoc\\workspace\\JTabbedPane\\src\\pieChart.jpg"));
		_btnPieChart.setText("");
		_btnPieChart.setToolTipText("Pie chart");
		_btnPieChart.addActionListener(new chartListener(_sps));
		_pnlDiagrammes.add(_btnPieChart);

		_btnPieChart3D = new JButton();
		_btnPieChart3D.setIcon(new ImageIcon(
				"C:\\Users\\hoc\\workspace\\JTabbedPane\\src\\pieChart3D.jpg"));
		_btnPieChart3D.setText("");
		_btnPieChart3D.setToolTipText("Pie chart 3D");
		_pnlDiagrammes.add(_btnPieChart3D);

		_btnDualAxis = new JButton();
		_btnDualAxis.setIcon(new ImageIcon(
				"C:\\Users\\hoc\\workspace\\JTabbedPane\\src\\da.png"));
		_btnDualAxis.setText("");
		_btnDualAxis.setToolTipText("Dual axis chart");
		_pnlDiagrammes.add(_btnDualAxis);
		_pnlDiagrammes.setVisible(false);
		toolBar.add(_pnlDiagrammes);

		insertion.addMouseListener(new InsertionListener(_pnlDiagrammes,
				_pnlInsertion));
		diagrammes.addMouseListener(new DiagramListener(_pnlDiagrammes,
				_pnlInsertion));

		toolBar.addSeparator();
	}

	public void saveFile(SpreadSheet _sps) {
		enregistrer.addActionListener(new saveFileDialogListener(_sps));
	}

}