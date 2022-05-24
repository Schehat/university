import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) {
			try {
				bestimme_bonus(2, 600);
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	static void bestimme_bonus(int mitarbeiter_id, double bonus) throws SQLException {
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:db01", 
                "KT0-NGF-U1", "testit2_");
		conn.setAutoCommit(false);
		if (bonus < 0) throw new SQLException("Bonus darf nicht negativ sein");
		boolean ok = false;
		String query = "SELECT Gehalt FROM mitarbeiter WHERE id = ?";
		try {
			try (PreparedStatement stmt = conn.prepareStatement(query)) {
				stmt.setInt(1, mitarbeiter_id);
				try (ResultSet rs = stmt.executeQuery()) {
					rs.next();
					double gehalt = rs.getInt("Gehalt");
					if (bonus / gehalt > 0.5) throw new SQLException("Bonus ist zu groﬂ");
						query = "UPDATE mitarbeiter SET bonus = ? WHERE id = ?";
						try (PreparedStatement ustmt = conn.prepareStatement(query)) {
							ustmt.setDouble(1, bonus);
							ustmt.setInt(2, mitarbeiter_id);
							if (ustmt.executeUpdate() != 1 ) throw new SQLException("Ein Fehler ist aufgetreten");
						}
					}
			}
			conn.commit();
			ok = true;
		} finally {
			if (!ok) conn.rollback();
		}
	}
}
