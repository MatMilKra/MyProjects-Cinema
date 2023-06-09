package MyProjects.Cinema.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import MyProjects.Cinema.Model.Movie;

@Service
public class MovieServiceImplementation implements MovieService {

	@Autowired
	public MovieServiceImplementation() throws SQLException {
		super();
	}

	@Override
	public List<Movie> search(String searchTab) throws SQLException {
		List<Movie> movies = new ArrayList<>();
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost:1521:xe");
		String query = "SELECT description,ticketprice,title FROM movie WHERE title like ? OR description LIKE ?";
		PreparedStatement ps = connection.prepareStatement(query);

		System.out.println("1");
		try {
			ps.setString(1, "%" + searchTab + "%");
			ps.setString(2, "%" + searchTab + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Movie movie = new Movie();
				movie.setTitle(rs.getString(3));
				movie.setDescription(rs.getString(1));
				movie.setTicketPrice(rs.getString(2));

				movies.add(movie);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		ps.close();
		connection.close();
		return movies;
	}

	@Override
	public void addMovie(Movie movie) throws SQLException {
		System.out.println("1");
		System.out.println(movie);
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:hr/hr@localhost:1521:xe");
		String query = "INSERT INTO movie(description,ticketprice,title) VALUES (?,?,?)";
		PreparedStatement ps = connection.prepareStatement(query);
		try {
			ps.setString(3, movie.getTitle());
			ps.setString(1, movie.getDescription());
			ps.setString(2, movie.getTicketPrice());
			ps.execute();
			System.out.println("2");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ps.close();
		connection.close();
	}



}
