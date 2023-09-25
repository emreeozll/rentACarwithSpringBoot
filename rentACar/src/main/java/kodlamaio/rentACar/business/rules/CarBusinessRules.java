package kodlamaio.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlamaio.rentACar.core.utilities.exception.BusinessException;
import kodlamaio.rentACar.dataAccess.abstracts.CarRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarBusinessRules {

	private final CarRepository carRepository;
	
	
	public void checkIfCarPlateExists(String Plate) {

		if (this.carRepository.existsByPlateIgnoreCase(Plate)) {

			throw new BusinessException("Plate already exists");
		}
	}

	public void checkIfCarIdExists(int id) {

		if (!this.carRepository.existsById(id)) {

			throw new BusinessException("Id not found!");
		}
	}
	
}
