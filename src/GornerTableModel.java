import javax.swing.table.AbstractTableModel;

public class GornerTableModel extends AbstractTableModel {

    private Double[] coefficients;
    private Double from;
    private Double to;
    private Double step;

    public GornerTableModel(Double from, Double to, Double step, Double[] coefficients) {
        this.from = from;
        this.to = to;
        this.step = step;
        this.coefficients = coefficients;
    }

    public Double getFrom() {
        return from;
    }

    public Double getTo() {
        return to;
    }

    public Double getStep() {
        return step;
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public int getRowCount() {
        return (int) Math.ceil((to - from) / step) + 1;
    }

    @Override
    public Object getValueAt(int row, int col) {

        double x = from + step * row;

        if (col == 0) {
            return x;
        } else if (col == 1) {
            double result = 0.0;

            for (int i = coefficients.length - 1; i >= 0; i--) {
                result = result * x + coefficients[i];
            }

            return result;
        } else if (col == 2) {
            double result = 0.0;

            for (int i = coefficients.length - 1; i >= 0; i--) {
                result = result * x + coefficients[i];
            }

            return result % 1 == 0; //остаток от деления если равер 0

        }

        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Значение X";
            case 1:
                return "Значение многочлена";
            case 2:
                return "Точное значение?";
            default:
                return "";
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (columnIndex == 2) {
            return Boolean.class;
        }
        return Double.class;
    }
}
