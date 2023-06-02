package MyProjects.Cinema;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import MyProjects.Cinema.Controller.Menu;
import MyProjects.Cinema.Model.Movie;
import MyProjects.Cinema.Model.User;
import MyProjects.Cinema.Service.MovieService;



@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class App {
	
	

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Menu menu = new Menu();
		User user = new User("user1","pass1");
		Movie movie1=new Movie("Star Wars","A new Hope", "15.0");
		Movie movie2=new Movie("Star Wars","Empire strikes back", "20.0");
		Movie movie3=new Movie("Star Wars","Return of the Jadi", "10.0");

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("App");
		EntityManager em = emf.createEntityManager();
		EntityTransaction trx = em.getTransaction();
		
		trx.begin();

//		em.merge(user);
		em.merge(movie1);
		em.merge(movie2);
		em.merge(movie3);
		trx.commit();
		
		em.close();
		emf.close();
		
		menu.mainMenu();
	
	}
}