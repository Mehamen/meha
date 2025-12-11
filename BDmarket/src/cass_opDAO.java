import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class cass_opDAO {

    public List<cass_op> getAllOps() {
        List<cass_op> list = new ArrayList<>();
        String sql = "SELECT * FROM cass_op";

        try (Connection conn = data.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                cass_op op = new cass_op(
                        rs.getInt("id_op"),
                        rs.getDate("Date"),
                        rs.getInt("Sum"),
                        rs.getInt("id_cassira"),
                        rs.getInt("id_cassa")
                );
                list.add(op);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }
}
