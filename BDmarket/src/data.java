import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class data{
		private static final String URL =  "jdbc:mysql://localhost:3306/cassa1";
			private static final String USER = "root";
			private static final String PASSWORD = "";
			
			public static Connection getConnection() throws SQLException {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					return DriverManager.getConnection(URL, USER, PASSWORD);
				} catch (ClassNotFoundException e) {
					throw new SQLException("MySQL Driver not found", e);
				}
			}
			
			public static void testConnection() {
				try (Connection conn = getConnection()) {
					if(conn != null) {
						System.out.println("Подключение к БД успешно!");
					}
				} catch (SQLException e) {
					System.out.println("Ошибка подключения: " + e.getMessage());
				}
			}

}