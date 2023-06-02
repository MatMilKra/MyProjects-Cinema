package MyProjects.Cinema.Controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import MyProjects.Cinema.Model.Movie;
import MyProjects.Cinema.Service.MovieService;
import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.ModelMap;

@Controller
public class SearchController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/search")
	public String search(ModelMap model, @RequestParam String searchTab) throws SQLException {
		List<Movie> movies = movieService.search(searchTab);
		model.addAttribute("items", movies);
		return "search";
	}

}
