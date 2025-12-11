import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class cassaDAO {
    public List<cassa> getAllCassa() {
        List<cassa> list = new ArrayList<>();
        String sql = "SELECT * FROM cassa";

        try (Connection conn = data.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new cassa(
                        rs.getInt("id_cassa"),
                        rs.getString("naim"),
                        rs.getString("Adres")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}