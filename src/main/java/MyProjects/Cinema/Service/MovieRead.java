package MyProjects.Cinema.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import MyProjects.Cinema.Model.Movie;

public class MovieRead {
	PreparedStatement ps;
	Connection connection;

	public MovieRead() throws SQLException {
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		String query = "SELECT title, description FROM MOVIE WHERE title LIKE ? OR description LIKE ?";
		ps = connection.prepareStatement(query);
	}

	public void find(String string) throws SQLException {
		ResultSet rs;
		List<Movie> listM = new ArrayList<>();
		Movie movie = new Movie();
		try {
			ps.setString(1, "%" + string + "%");
			ps.setString(2, "%" + string + "%");
			rs = ps.executeQuery();

			while (rs.next()) {
				movie.setTitle(rs.getString(1));
				movie.setDescription(rs.getString(2));
				listM.add(movie);

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(listM);
		close();
	}

	public void close() throws SQLException {
		ps.close();
		connection.close();
	}

}
