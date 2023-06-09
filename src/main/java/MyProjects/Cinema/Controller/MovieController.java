package MyProjects.Cinema.Controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import MyProjects.Cinema.Model.Movie;
import MyProjects.Cinema.Service.MovieService;

import java.util.List;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.ModelMap;

@Controller
public class MovieController {

	@Autowired
	private MovieService movieService;

	@GetMapping("/")
	public String goIndex(ModelMap model) {

		return "index";
	}

	@GetMapping("/search")
	public String search(ModelMap model, @RequestParam String searchTab) throws SQLException {
		List<Movie> movies = movieService.search(searchTab);
		model.addAttribute("items", movies);
		return "search";
	}

	@GetMapping(value = "/add")
	public String goToAdd(ModelMap model) {

		return "add";
	}

	@RequestMapping(value = "/add")
	public String addeNewItem(@RequestParam String title, @RequestParam String ticketPrice,
			@RequestParam String description) throws SQLException {

		Movie movie = new Movie(title, description, ticketPrice);
		movieService.addMovie(movie);

		return "/add";
	}

}
