import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
			try {
				ausleihen(2, 1);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	static void ausleihen(int rad_id, int kunde_id) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:db01", 
                "KT0-NGF-U1", "testit2_");
		conn.setAutoCommit(false);
		boolean ok = false;
		String query = "SELECT * FROM Ausleihungen WHERE rad_id = ?";
		try {
			try (PreparedStatement stmt = conn.prepareStatement(query)) {
				stmt.setInt(1, rad_id);
				try (ResultSet rs = stmt.executeQuery()) {
					if(rs.next()) throw new SQLException("Fahrrad bereits vergeben");
				}
			}
			
			query = "INSERT INTO Ausleihungen VALUES (?, ?)";
			try (PreparedStatement i_stmt = conn.prepareStatement(query)) {
				i_stmt.setInt(1, kunde_id);
				i_stmt.setInt(2, rad_id);
				int n = i_stmt.executeUpdate();
				if (n != 1 ) throw new SQLException("Fehler beim Einfügen");
			}
			
			conn.commit();
			ok = true;
		} finally {
			if (!ok) conn.rollback();
			System.out.println("rollback");
		}
	}
}

