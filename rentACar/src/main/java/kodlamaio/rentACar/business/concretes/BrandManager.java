package kodlamaio.rentACar.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import kodlamaio.rentACar.entities.concretes.Brand;
import kodlamaio.rentACar.business.abstracts.BrandService;
import kodlamaio.rentACar.dataAccess.abstracts.BrandRepository;

//bu sinif bir business nesnesidir

@Service
public class BrandManager implements BrandService {

	private BrandRepository brandRepository; // dependency injection

	// Uygulamayi tara, kim servisleri implement ediyor, onun new'lenmis halini bana
	// getir. Otomatik

	@Autowired
	public BrandManager(BrandRepository brandRepository) {
		this.brandRepository = brandRepository;
	}

	@Override
	public List<Brand> getAll() {

		return brandRepository.getAll();
	}

}
