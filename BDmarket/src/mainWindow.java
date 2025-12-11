import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class mainWindow extends JFrame {

    private JTable tableCassa;
    private JTable tableCassir;
    private JTable tableCassOp;

    public mainWindow() {
        setTitle("База данных касс");
        setSize(900, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();
        tabs.add("Кассы", panelCassa());
        tabs.add("Кассиры", panelCassir());
        tabs.add("Операции", panelCassOp());

        add(tabs, BorderLayout.CENTER);

        // Подгружаем данные при старте
        loadCassa();
        loadCassir();
        loadCassOp();
    }

    // --- вкладка для CASSA
    private JPanel panelCassa() {
        JPanel panel = new JPanel(new BorderLayout());

        tableCassa = new JTable();
        panel.add(new JScrollPane(tableCassa), BorderLayout.CENTER);

        JButton refresh = new JButton("Обновить");
        refresh.addActionListener(e -> loadCassa());

        JButton exit = new JButton("Выход");
        exit.addActionListener(e -> System.exit(0));

        JPanel buttons = new JPanel();
        buttons.add(refresh);
        buttons.add(exit);

        panel.add(buttons, BorderLayout.SOUTH);
        return panel;
    }

    // --- вкладка для CASSIR
    private JPanel panelCassir() {
        JPanel panel = new JPanel(new BorderLayout());

        tableCassir = new JTable();
        panel.add(new JScrollPane(tableCassir), BorderLayout.CENTER);

        JButton refresh = new JButton("Обновить");
        refresh.addActionListener(e -> loadCassir());

        JButton exit = new JButton("Выход");
        exit.addActionListener(e -> System.exit(0));

        JPanel buttons = new JPanel();
        buttons.add(refresh);
        buttons.add(exit);

        panel.add(buttons, BorderLayout.SOUTH);
        return panel;
    }

    // --- вкладка Cass_op
    private JPanel panelCassOp() {
        JPanel panel = new JPanel(new BorderLayout());

        tableCassOp = new JTable();
        panel.add(new JScrollPane(tableCassOp), BorderLayout.CENTER);

        JButton refresh = new JButton("Обновить");
        refresh.addActionListener(e -> loadCassOp());

        JButton exit = new JButton("Выход");
        exit.addActionListener(e -> System.exit(0));

        JPanel buttons = new JPanel();
        buttons.add(refresh);
        buttons.add(exit);

        panel.add(buttons, BorderLayout.SOUTH);
        return panel;
    }

    private void loadCassa() {
        String sql = "SELECT id_cassa, naim, Adres FROM cassa";
        try (Connection c = data.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            DefaultTableModel model = new DefaultTableModel(
                new String[]{"ID", "Название", "Адрес"}, 0
            );

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id_cassa"),
                        rs.getString("naim"),
                        rs.getString("Adres")
                });
            }

            tableCassa.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Ошибка загрузки Cassa: " + e.getMessage());
        }
    }

    // --- Таблица CASSIR
    private void loadCassir() {
        String sql = "SELECT id_cassira, name, surname, otchestvo, job_title FROM cassir";
        try (Connection c = data.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            DefaultTableModel model = new DefaultTableModel(
                    new String[]{"ID", "Имя", "Фамилия", "Отчество", "Должность"}, 0
            );

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id_cassira"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("otchestvo"),
                        rs.getString("job_title")
                });
            }

            tableCassir.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Ошибка загрузки Cassir: " + e.getMessage());
        }
    }

    // --- Таблица CASS_OP
    private void loadCassOp() {
        String sql = "SELECT id_op, Date, Sum, id_cassira, id_cassa FROM cass_op";
        try (Connection c = data.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            DefaultTableModel model = new DefaultTableModel(
                new String[]{"ID", "Дата", "Сумма", "ID Кассир", "ID Касса"}, 0
            );

            while (rs.next()) {
                model.addRow(new Object[]{
                        rs.getInt("id_op"),
                        rs.getDate("Date"),
                        rs.getInt("Sum"),
                        rs.getInt("id_cassira"),
                        rs.getInt("id_cassa")
                });
            }

            tableCassOp.setModel(model);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"Ошибка загрузки CassOp: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            mainWindow window = new mainWindow();
            window.setVisible(true);
        });
    }
}