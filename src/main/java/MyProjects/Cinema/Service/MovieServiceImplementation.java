package MyProjects.Cinema.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import MyProjects.Cinema.Model.Movie;



public class MovieServiceImplementation implements MovieService{
	PreparedStatement ps;
	@Override
	public List<Movie> search(String searchTab) throws SQLException {
		List<Movie> movies = new ArrayList<>();
		DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/xe");
		String query = "SELECT title, description FROM movie WHERE title = ?";
		ps = connection.prepareStatement(query);
		
		
		try {	ps.setString(1, searchTab);
		ResultSet rs = ps.executeQuery();
		
		
//		if (rs.next()) {
//			return new User(username, rs.getString(1), rs.getString(2));
//			
//		}
		while(rs.next()) {
			Movie movie=new Movie();
			movie.setTitle(rs.getString(1));
			connection.close();
			ps.close();
			movies.add(movie);
		}
		
	
} catch (SQLException e) {
	e.printStackTrace();
}
	return movies;
	}

}
