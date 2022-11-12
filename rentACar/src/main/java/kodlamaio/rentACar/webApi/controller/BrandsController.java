package kodlamaio.rentACar.webApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import kodlamaio.rentACar.business.abstracts.BrandService;
import kodlamaio.rentACar.entities.concretes.Brand;

@RestController // Annotation  bu sinif bir controller nesnesidir
@RequestMapping("api/brands")
public class BrandsController {

	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}

	@GetMapping("/getall")
	public List<Brand> getAll(){
		return brandService.getAll();
	}
	
	
}
