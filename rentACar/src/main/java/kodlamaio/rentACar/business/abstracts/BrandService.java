package kodlamaio.rentACar.business.abstracts;

import java.util.List;

import kodlamaio.rentACar.business.requests.CreateBrandRequest;
import kodlamaio.rentACar.business.requests.DeleteBrandRequest;
import kodlamaio.rentACar.business.requests.UpdateBrandsRequest;
import kodlamaio.rentACar.business.responses.GetAllBrandsResponse;
import kodlamaio.rentACar.business.responses.GetByIdBrandResponse;

public interface BrandService {

	public void addBrand(CreateBrandRequest createBrandRequest);

	public void deleteBrand(DeleteBrandRequest deleteBrandRequest);

	public void updateBrand(UpdateBrandsRequest updateBrandsRequest);

	List<GetAllBrandsResponse> getAll();

	GetByIdBrandResponse getByBrandId(int id);

}
