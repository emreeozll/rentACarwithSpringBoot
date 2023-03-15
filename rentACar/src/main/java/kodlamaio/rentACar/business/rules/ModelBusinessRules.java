package kodlamaio.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlamaio.rentACar.core.utilities.exception.BusinessException;
import kodlamaio.rentACar.dataAccess.abstracts.ModelRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelBusinessRules {

	private final ModelRepository modelRepository;

	public void checkIfModelNameExists(String name) {

		if (this.modelRepository.existsByNameIgnoreCase(name)) {

			throw new BusinessException("Model aldready exists");
		}
	}

	
	public void checkIfModelIdExists(int id) {

		if (!this.modelRepository.existsById(id)) {

			throw new BusinessException("Id not found!");
		}
	}
	
	
	
	
	
}
