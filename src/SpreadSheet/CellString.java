package SpreadSheet;

public class CellString {
	
	private static final String patternCell = "([A-Z]+)([1-9]+)";
	private static final String patternColumn = "([A-Z]+)";
	private static final String patternRow = "([0-9]+)";
	
	public static boolean isCell(String cell){
		return cell.matches(patternCell);
	}
	
	public static String[] getRowIndex(String cell){
		return cell.split(patternRow);
	}
	
	public static String[] getColumnName (String cell){
		return cell.split(patternColumn);
	}
	
	public static String getNthColumnName(int n) {
	    String name = "";
	    while (n > 0) {
	        n--;
	        name = (char)('A' + n%26) + name;
	        n /= 26;
	    }
	    return name;
	}
	
	public static int getColNum (String colName) {

	    //remove any whitespace
	    colName = colName.trim();

	    StringBuffer buff = new StringBuffer(colName);

	    //string to lower case, reverse then place in char array
	    char chars[] = buff.reverse().toString().toLowerCase().toCharArray();

	    int retVal=0, multiplier=0;

	    for(int i = 0; i < chars.length;i++){
	        //retrieve ascii value of character, subtract 96 so number corresponds to place in alphabet. ascii 'a' = 97 
	        multiplier = (int)chars[i]-96;
	        //mult the number by 26^(position in array)
	        retVal += multiplier * Math.pow(26, i);
	    }
	    return retVal;
	}
	
	public static String[] integerColumnNames(int size){
		String[] list = new String[size];
		for (int i=0; i< size; i++){
			list[i] =Integer.toString(i+1);
		}
		return list;
	}
	
}
