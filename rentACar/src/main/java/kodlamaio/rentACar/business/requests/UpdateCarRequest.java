package kodlamaio.rentACar.business.requests;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import kodlamaio.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

	@NotNull
	private int id;
	
	@NotNull // Bu annotation'u alan property'nin null olmamasını sağlar
	@NotBlank // Yalnızca text alanlara uygulanabilir ve özelliğin null olmasını ve whitespace olmasını engeller.
	private String plate;

	@NotNull
	@Positive
	private double dailyPrice;

	@NotNull
	private int modelYear;

	@NotNull
	@NotBlank
	private String state;

	@NotNull
	private Model modelId;
}
