package kodlamaio.rentACar.business.requests;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeleteModelRequest {

	@NotNull
	private int id;
	
}
