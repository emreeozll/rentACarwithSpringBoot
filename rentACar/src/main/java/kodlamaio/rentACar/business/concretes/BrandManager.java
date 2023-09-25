package kodlamaio.rentACar.business.concretes;

import java.util.List;


import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlamaio.rentACar.business.abstracts.BrandService;
import kodlamaio.rentACar.business.requests.CreateBrandRequest;
import kodlamaio.rentACar.business.requests.DeleteBrandRequest;
import kodlamaio.rentACar.business.requests.UpdateBrandsRequest;
import kodlamaio.rentACar.business.responses.GetAllBrandsResponse;
import kodlamaio.rentACar.business.responses.GetByIdBrandResponse;
import kodlamaio.rentACar.business.rules.BrandBusinessRules;
import kodlamaio.rentACar.core.utilities.mappers.ModelMapperService;
import kodlamaio.rentACar.dataAccess.abstracts.BrandRepository;
import kodlamaio.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BrandManager implements BrandService {

	private final BrandRepository brandRepository; // dependency injection
	private final ModelMapperService mapperService;
	private final BrandBusinessRules brandBusinessRules;

	
	/* Java dunyasında populer olan mapperlar biraz aşırı reflection'lar
	 yaptığı için hata olabiliyor. Belli bir noktaya kadar map'i yaptıktansonra
	 özel bir durum varsa kendimiz manuel set edebiliriz. */
	@Override
	public void addBrand(CreateBrandRequest createBrandRequest) {
       
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		Brand brand = this.mapperService.forRequest().map(createBrandRequest, Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public void deleteBrand(DeleteBrandRequest deleteBrandRequest) {

		this.brandBusinessRules.checkIfBrandIdExists(deleteBrandRequest.getId());
		Brand brand = this.mapperService.forRequest().map(deleteBrandRequest, Brand.class);
		this.brandRepository.delete(brand);
	}

	@Override
	public void updateBrand(UpdateBrandsRequest updateBrandsRequest) {

		this.brandBusinessRules.checkIfBrandIdExists(updateBrandsRequest.getId());
		Brand brand = this.mapperService.forRequest().map(updateBrandsRequest, Brand.class);
		this.brandRepository.save(brand);
	}

	@Override
	public List<GetAllBrandsResponse> getAll() {

		List<Brand> brands = brandRepository.findAll();

		List<GetAllBrandsResponse> allBrandsResponses = brands.stream()
				.map(brand -> this.mapperService.forResponse().map(brand, GetAllBrandsResponse.class))
				.collect(Collectors.toList());
		return allBrandsResponses;

	}

	@Override
	public GetByIdBrandResponse getByBrandId(int id) {

		Brand brand = this.brandRepository.findById(id).orElseThrow();
		GetByIdBrandResponse brandResponse = this.mapperService.forResponse().map(brand, GetByIdBrandResponse.class);
		return brandResponse;

	}



}
