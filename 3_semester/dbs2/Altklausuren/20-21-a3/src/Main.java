import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
			try {
				ausleihen(2, 2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	static void ausleihen(int fahrrad_id, int kunde_id) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:db01", 
                "KT0-NGF-U1", "testit2_");
		conn.setAutoCommit(false);
		boolean ok = false;
		String query = "SELECT * FROM Fahrrad WHERE fahrrad_id = ?";
		try {
			try (PreparedStatement stmt = conn.prepareStatement(query)) {
				stmt.setInt(1, fahrrad_id);
				try (ResultSet rs = stmt.executeQuery()) {
					rs.next();
					rs.getInt("kunde_id");
					if (rs.wasNull()) {
						query = "UPDATE Fahrrad SET kunde_id = ? WHERE fahrrad_id = ?";
						try (PreparedStatement ustmt = conn.prepareStatement(query)) {
							ustmt.setInt(1, kunde_id);
							ustmt.setInt(2, fahrrad_id);
							int n = ustmt.executeUpdate();
							if (n != 1 ) throw new SQLException("Ein Fehler ist aufgetreten");
						}
					} else {
						throw new SQLException("Fahrrad bereits verliehen");
					}
				}
			}
			conn.commit();
			ok = true;
		} finally {
			if (!ok) {
				conn.rollback();
			}
		}
	}
}
