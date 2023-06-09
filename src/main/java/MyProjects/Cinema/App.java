package MyProjects.Cinema;

import java.io.IOException;
import java.sql.SQLException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;


@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class App {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		SpringApplication.run(App.class, args);

		System.out.println("Application has started.");
	}
}