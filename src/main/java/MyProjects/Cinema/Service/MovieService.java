package MyProjects.Cinema.Service;

import java.sql.SQLException;
import java.util.List;

import MyProjects.Cinema.Model.Movie;

public interface MovieService {

	List<Movie> search(String searchTab) throws SQLException;

}
