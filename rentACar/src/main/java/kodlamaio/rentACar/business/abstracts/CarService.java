package kodlamaio.rentACar.business.abstracts;

import java.util.List;

import kodlamaio.rentACar.business.requests.CreateCarRequest;
import kodlamaio.rentACar.business.requests.DeleteCarRequest;
import kodlamaio.rentACar.business.requests.UpdateCarRequest;
import kodlamaio.rentACar.business.responses.GetAllCarResponse;
import kodlamaio.rentACar.business.responses.GetByIdCarResponse;

public interface CarService {

	
	public void addCar(CreateCarRequest createCarRequest);
	
	public void deleteCar(DeleteCarRequest deleteCarRequest);
	
	public void updateCar(UpdateCarRequest updateCarRequest);
	
	public List<GetAllCarResponse> getAll();
	
	public GetByIdCarResponse getByIdCar(int id);
	
}
