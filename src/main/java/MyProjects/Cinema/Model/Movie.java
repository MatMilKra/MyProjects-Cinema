package MyProjects.Cinema.Model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Movie {

	@Id
//	@GeneratedValue
	Integer id;
	String title;
	String description;
	String ticketPrice;
	static Integer nextId = 1;

	public Movie() {
		super();
	}

	public Movie(String title, String description, String ticketPrice) {
		super();
		this.title = title;
		this.description = description;
		this.ticketPrice = ticketPrice;
		id = nextId;
		nextId += 1;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(String ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	public Integer getId() {
		return id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, id, ticketPrice, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return Objects.equals(description, other.description)// && Objects.equals(id, other.id)
				&& Objects.equals(ticketPrice, other.ticketPrice) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + "\n Description=" + description + ", ticketPrice=" + ticketPrice
				+ "] \n";
	}

}
