import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class cassirDAO {
	 public List<cassir> getAllCassirs() {
	        List<cassir> list = new ArrayList<>();

	        String sql = "SELECT * FROM cassir";

	        try (Connection conn = data.getConnection();
	             Statement stmt = conn.createStatement();
	             ResultSet rs = stmt.executeQuery(sql)) {

	            while (rs.next()) {
	                cassir c = new cassir(
	                        rs.getInt("id_cassira"),
	                        rs.getString("name"),
	                        rs.getString("surname"),
	                        rs.getString("otchestvo"),
	                        rs.getString("job_title")
	                );
	                list.add(c);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return list;
	    }
}
