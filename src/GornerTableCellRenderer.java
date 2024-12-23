import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.text.DecimalFormat; // Для форматирования чисел
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class GornerTableCellRenderer extends DefaultTableCellRenderer {
    private String needle = ""; // Игла для поиска
    private final DecimalFormat formatter = new DecimalFormat("#.##"); // Форматировщик для округления до 2 знаков

    public void setNeedle(String needle) {
        this.needle = needle;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int col) {
        // Форматируем значение, если это число
        String formattedDouble;
        if (value instanceof Double) {
            formattedDouble = formatter.format(value); // Округляем значение до 2 знаков
        } else {
            formattedDouble = value.toString();
        }

        // Создаем панель и метку
        JPanel panel = new JPanel();
        JLabel label = new JLabel(formattedDouble); // Используем отформатированное значение
        panel.add(label);
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        // Устанавливаем цвет фона в зависимости от совпадения с иголкой
        if ((col == 0 || col == 1) && needle != null && needle.equals(formattedDouble)) {
            panel.setBackground(Color.RED);
        } else {
            panel.setBackground(Color.WHITE);
        }

        return panel; // Возвращаем компонент для отображения
    }
}
