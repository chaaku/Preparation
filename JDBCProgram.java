import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCProgram {

	public static void main(String args[]) throws SQLException {

		final String DB_URL = "jdbc:mysql://localhost/EMP";

		final String USER = "username";
		final String PASSWORD = "password";

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {

			// step1 load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// step2 create the connection object
			con = DriverManager.getConnection(DB_URL, USER, PASSWORD);

			// step3 create the statement object
			stmt = con.createStatement();

			// step4 execute query
			rs = stmt.executeQuery("select * from emp");

			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));

			// step5 close the connection object

		} catch (Exception e) {
			System.out.println(e);
		}

		finally {
			con.close();
			stmt.close();
			rs.close();

		}

	}
}