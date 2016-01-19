package componentListener;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileWriter;
import java.io.PrintWriter;

import javax.swing.*;

import SpreadSheet.*;
import Analyseur.Evaluateur;

public class JTextField_Listener implements KeyListener {

	JTextField jtf;
	public static int i = 0;
	SpreadSheet _sps;
	
	public JTextField_Listener(JTextField jtf , SpreadSheet sps) {
		_sps = sps;
		this.jtf = jtf;
	}

	public void keyPressed(KeyEvent evt) {
		if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
			try {
				int selectedRow = _sps.getSelectedRow();  
                int selectedColumn = _sps.getSelectedColumn();
                PrintWriter fichier = new PrintWriter (new FileWriter ("a.txt")) ;
                
                /*
                int row =CellString.getColNum(CellString.getRowIndex(jtf.getText())[0])-1;
        		int column = Integer.parseInt(CellString.getColumnName(jtf.getText())[1])-1;
        		System.out.println("Row : "+row+"   Column  : "+column);
        		SheetCell sc = (SheetCell)_sps.getValueAt(row, column);
        		System.out.println("Row : "+row+"   Column  : "+column+" **** Cell["+row+"]["+column+"] : "+sc.getValue());
                */
				fichier.println(jtf.getText());
				fichier.close();
				Evaluateur.Evaluer(jtf.getText(),i,_sps);
				double rParse= Evaluateur.resultParsing;
				if ( rParse != -1){
					_sps.setFormulaAt(selectedRow, selectedColumn, jtf.getText());
					_sps.setValAt(selectedRow, selectedColumn, Double.toString(rParse));
					_sps.repaint();
				}else{
					System.out.println("Erreur");
				}
				
				i++;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public void keyReleased(KeyEvent arg0) {

	}

	public void keyTyped(KeyEvent arg0) {

	}

}
