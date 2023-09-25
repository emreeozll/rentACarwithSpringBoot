package kodlamaio.rentACar.business.responses;

import kodlamaio.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarResponse {


	private int id;

	private String plate;

	private double dailyPrice;

	private int modelYear;
	
	private String state; // 1-Avaliable 2-Rented 3-Maintenance
	
	private Model model;
	
}
