package SpreadSheet;

import java.awt.*;
import java.io.Serializable;
import java.util.*;

@SuppressWarnings("serial")
public class SheetCell implements Serializable {

	public static final boolean DEBUG = false;

	static final int UNDEFINED = 0;
	static final int EDITED = 1;
	static final int UPDATED = 2;
	static final boolean USER_EDITION = true;
	static final boolean UPDATE_EVENT = false;

	Object value;
	String formula;
	int state;
	@SuppressWarnings("rawtypes")
	Vector listeners;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getFormula() {
		return formula;
	}

	public void setFormula(String formula) {
		this.formula = formula;
	}

	@SuppressWarnings("rawtypes")
	Vector listenees;
	Color background;
	Color foreground;
	int row;
	int column;

	@SuppressWarnings("rawtypes")
	public SheetCell(int r, int c) {
		row = r;
		column = c;
		value = null;
		formula = null;
		state = UNDEFINED;
		listeners = new Vector();
		listenees = new Vector();
		background = Color.white;
		foreground = Color.black;
	}

	SheetCell(int r, int c, String value, String formula) {
		this(r, c);
		this.value = value;
		this.formula = formula;
	}

	void userUpdate() {

		for (int ii = 0; ii < listenees.size(); ii++) {
			SheetCell c = (SheetCell) listenees.get(ii);
			c.listeners.remove(this);
		}
		listenees.clear();

		updateListeners();
		state = UPDATED;
	}

	void updateListeners() {
		for (int ii = 0; ii < listeners.size(); ii++) {
			SheetCell cell = (SheetCell) listeners.get(ii);
			if (DEBUG)
				System.out.println("Listener updated.");
			cell.updateListeners();
		}
	}

	public String toString() {
		if (state == EDITED && formula != null)
			return formula;
		else if (value != null)
			return value.toString();
		else
			return null;
	}

}