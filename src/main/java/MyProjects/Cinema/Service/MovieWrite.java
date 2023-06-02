package MyProjects.Cinema.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import MyProjects.Cinema.Model.Movie;

public class MovieWrite {

	PreparedStatement ps;
	Connection connection;

	public MovieWrite() throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		String query = "INSERT INTO movie VALUES (?,?,?,?)";
		ps = connection.prepareStatement(query);
	}

	public void addmovie(Movie movie) throws SQLException {
		try {
			ps.setLong(1, movie.getId());
			ps.setString(2, movie.getTitle());
			ps.setString(3, movie.getDescription());
			ps.setString(4, movie.getTicketPrice());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close();
	}

	public void close() throws SQLException {
		ps.close();
		connection.close();
	}

}
