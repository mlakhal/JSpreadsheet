package SpreadSheet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.table.*;

@SuppressWarnings("serial")
public class SpreadSheetModel extends AbstractTableModel implements
		Serializable {

	private String[] columnNames;
	
	private SpreadSheet _dpyTable;

	static final boolean DEBUG = false;

	private int _nbRow;
	private int _nbColumn;

	protected SheetCell[][] cells;

	SpreadSheetModel(SheetCell[][] cells, SpreadSheet table) {
		_dpyTable = table;
		_nbRow = cells.length;
		_nbColumn = cells[0].length;
		columnNames = CellString.integerColumnNames(_nbColumn);
		this.cells = cells;
	}

	public void setFormulaAt(int row , int column, String formula){
		cells[row][column].setFormula(formula);
	}
	
	public void setValAt(int row , int column, String value){
		cells[row][column].setValue(value);
	}
	
	public SheetCell[][] getCells() {
		return cells;
	}

	public void writeObject(ObjectOutputStream oos) throws IOException {
		oos.writeObject(cells);
		oos.writeInt(_nbColumn);
		oos.writeInt(_nbRow);
	}

	public void readObject(ObjectInputStream ois) throws IOException,
			ClassNotFoundException {
		cells = (SheetCell[][]) ois.readObject();
		_nbColumn = ois.readInt();
		_nbRow = ois.readInt();
	}

	public int getRowCount() {
		return _nbRow;
	}

	public int getColumnCount() {
		return _nbColumn;
	}

	public boolean isCellEditable(int row, int col) {
		return true;
	}
	
	public String getColumnName(int index) {
	    return columnNames[index];
	}

	public Object getValueAt(int row, int column) {
		return cells[row][column];
	}

	void setEditMode(int row, int column) {
		cells[row][column].state = SheetCell.EDITED;
	}

	void setDisplayMode(int row, int column) {
		cells[row][column].state = SheetCell.UPDATED;
	}

	public void addColumn() {
		SheetCell[][] newCells;
		newCells = new SheetCell[_nbRow][_nbColumn + 1];
		for (int ii = 0; ii < _nbRow; ii++) {
			for (int jj = 0; jj < _nbColumn + 1; jj++) {
				if (jj == _nbColumn) {
					newCells[ii][jj] = new SheetCell(ii, jj);
				} else {
					newCells[ii][jj] = cells[ii][jj];
				}
			}
		}
		cells = newCells;
		_nbColumn++;
		columnNames = CellString.integerColumnNames(_nbColumn);
		SpreadSheetModel newModel = new SpreadSheetModel(newCells,_dpyTable);
		_dpyTable.setModel(newModel);
		_dpyTable.repaint();
		fireTableStructureChanged();
	}

	public void addRow() {
		SheetCell[][] newCells;
		newCells = new SheetCell[_nbRow + 1][_nbColumn];
		for (int ii = 0; ii < _nbRow + 1; ii++) {
			for (int jj = 0; jj < _nbColumn; jj++) {
				if (ii == _nbRow) {
					newCells[ii][jj] = new SheetCell(ii, jj);
				} else {
					newCells[ii][jj] = cells[ii][jj];
				}
			}
		}
		cells = newCells;
		_nbRow++;
		SpreadSheetModel newModel = new SpreadSheetModel(newCells,_dpyTable);
		SpreadSheet _sp = new SpreadSheet(cells,_nbRow,_nbColumn);
		_sp.setModel(newModel);
		_dpyTable = _sp;
		_dpyTable.setModel(newModel);
		_dpyTable.repaint();
	}

	public void setValueAt(Object value, int row, int column) {

		String input = (String) value;

		cells[row][column].setValue(input);
		cells[row][column].userUpdate();
		fireTableCellUpdated(row, column);
		_dpyTable.repaint();

	}

}