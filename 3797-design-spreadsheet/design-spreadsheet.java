class Spreadsheet {

    private Map<String, Integer> cellValues;

    public Spreadsheet(int rows) {
        cellValues = new HashMap<>();
    }
    
    public void setCell(String cell, int value) {
        cellValues.put(cell, value);
    }
    
    public void resetCell(String cell) {
        cellValues.remove(cell);
    }
    
    public int getValue(String formula) {
         String expr = formula.substring(1);
        String[] parts = expr.split("\\+");
        int sum = 0;
        for (String part : parts) {
            if (part.length() == 0) {
                continue;
            }
            char c0 = part.charAt(0);
            if (Character.isDigit(c0)) {
                sum += Integer.parseInt(part);
            } else {
                sum += cellValues.getOrDefault(part, 0);
            }
        }
        return sum;
    }
}

/**
 * Your Spreadsheet object will be instantiated and called as such:
 * Spreadsheet obj = new Spreadsheet(rows);
 * obj.setCell(cell,value);
 * obj.resetCell(cell);
 * int param_3 = obj.getValue(formula);
 */