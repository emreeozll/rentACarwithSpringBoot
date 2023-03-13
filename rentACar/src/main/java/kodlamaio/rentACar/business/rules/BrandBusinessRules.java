package kodlamaio.rentACar.business.rules;

import org.springframework.stereotype.Service;

import kodlamaio.rentACar.core.utilities.exception.BusinessException;
import kodlamaio.rentACar.dataAccess.abstracts.BrandRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandBusinessRules {

	private final BrandRepository brandRepository;

	//Çalışma anındaki bütün hatalar business'ta olamayacağı için
	//kendi business hatalarımızı oluşturmamız gerekli
	// Bunun bir business ahtası olduğunu anlatmamız lazım. Kendi sınıfımızı oluşturuyoruz.
	
	public void checkIfBrandNameExists(String Name) {

		if (this.brandRepository.existsByNameIgnoreCase(Name)) {

			throw new BusinessException("Brand already exists");
		}
	}

	public void checkIfBrandIdExists(int id) {

		if (!this.brandRepository.existsById(id)) {

			throw new BusinessException("Id not found!");
		}
	}

		
	
	
	
	
}
