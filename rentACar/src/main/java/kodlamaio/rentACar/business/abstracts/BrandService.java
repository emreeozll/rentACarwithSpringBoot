package kodlamaio.rentACar.business.abstracts;

import java.util.List;

import kodlamaio.rentACar.business.requests.CreateBrandRequest;
import kodlamaio.rentACar.business.requests.DeleteBrandRequest;
import kodlamaio.rentACar.business.requests.UpdateBrandsRequest;
import kodlamaio.rentACar.business.responses.GetAllBrandsResponse;
import kodlamaio.rentACar.business.responses.GetByIdBrandResponse;

public interface BrandService {

	List<GetAllBrandsResponse> getAll();
	void add(CreateBrandRequest createBrandRequest);
	void delete(DeleteBrandRequest deleteBrandRequest);
	void update(UpdateBrandsRequest updateBrandsRequest);
	GetByIdBrandResponse getByBrandId(int id);
	
}
