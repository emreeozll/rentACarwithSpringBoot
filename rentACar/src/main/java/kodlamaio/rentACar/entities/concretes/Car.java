package kodlamaio.rentACar.entities.concretes;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "plate", unique = true)
	private String plate;

	@Column(name = "daily_price")
	private double dailyPrice;

	@Column(name = "model_year")
	private int modelYear;

	@Column(name = "state")
	private String state; // 1-Avaliable 2-Rented 3-Maintenance
	
	@ManyToOne
	@JoinColumn(name ="model_id")
	private Model model;

}
