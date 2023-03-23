import java.sql.*;

// Fragt Datensätze von Tabelle COFFEES ab
public class Select {

    public static void main(String[] args) {
        Connection con = null;
        Statement stmt = null;
        try {
            con = ConnectionManager.getConnection();
            stmt = con.createStatement();
            // Select durchführen
            String query = "select COF_NAME, PRICE from COFFEES";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            // ResultSet lesen und ausgeben
            String cof_name = "";
            double price = 0.0;
            while (rs.next()) {
                cof_name = rs.getString("COF_NAME");
                price = rs.getDouble("PRICE");
                System.out.println(cof_name + " " + price);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println(e.getSQLState());
            System.out.println(e.getErrorCode());
            e.printStackTrace();
        } finally {
            try {
                stmt.close();
                con.close();
                System.out.println("aufgeraeumt");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}