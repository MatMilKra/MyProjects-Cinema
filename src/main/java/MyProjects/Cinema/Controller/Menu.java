package MyProjects.Cinema.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

import MyProjects.Cinema.Model.Movie;
import MyProjects.Cinema.Service.MovieRead;
import MyProjects.Cinema.Service.MovieService;
import MyProjects.Cinema.Service.MovieWrite;

public class Menu {
	MovieService movieService;
	MovieWrite movieWrite;
	MovieRead movieRead;

	public Menu() {
		super();
//	this.movieService = movieService;
	}

	public void mainMenu() throws IOException, SQLException {

		System.out.println("     ****************************************");
		System.out.println("     *          Welcome to Cinema Site      *");
		System.out.println("     ****************************************");
		System.out.println("     What you wanna do?");
		System.out.println("     1. See all movies");
		System.out.println("     2. Find a movie");
		System.out.println("     3. Add a movie");

		Scanner skan = new Scanner(System.in);
		int choose = skan.nextInt();

		while (choose != 0) {
			switch (choose) {
			case 1:
				// findAll();
				break;

			case 2:
				find();

				break;

			case 3:
				add();

				break;

			}

		}
	}

	public void add() throws IOException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter title: ");
		String title = br.readLine();
		System.out.println("Enter description: ");
		String description = br.readLine();
		System.out.println("Enter ticket price: ");
		String ticketPrice = br.readLine();

		Movie movie = new Movie(title, description, ticketPrice);
		movieWrite = new MovieWrite();
		movieWrite.addmovie(movie);

	}

	public void find() throws IOException, SQLException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Find by title or description: ");
		String string = br.readLine();
		movieRead = new MovieRead();
		movieRead.find(string);
	}
}
