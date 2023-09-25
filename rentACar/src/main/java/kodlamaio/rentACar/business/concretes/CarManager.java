package kodlamaio.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlamaio.rentACar.business.abstracts.CarService;
import kodlamaio.rentACar.business.requests.CreateCarRequest;
import kodlamaio.rentACar.business.requests.DeleteCarRequest;
import kodlamaio.rentACar.business.requests.UpdateCarRequest;
import kodlamaio.rentACar.business.responses.GetAllCarResponse;
import kodlamaio.rentACar.business.responses.GetByIdCarResponse;
import kodlamaio.rentACar.business.rules.CarBusinessRules;
import kodlamaio.rentACar.core.utilities.mappers.ModelMapperService;
import kodlamaio.rentACar.dataAccess.abstracts.CarRepository;
import kodlamaio.rentACar.entities.concretes.Car;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CarManager implements CarService {

	private final CarRepository carRepository;
	private final ModelMapperService modelMapperService;
	private final CarBusinessRules carBusinessRules;

	@Override
	public void addCar(CreateCarRequest createCarRequest) {

		carBusinessRules.checkIfCarPlateExists(createCarRequest.getPlate());
		Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
		this.carRepository.save(car);

	}

	@Override
	public void deleteCar(DeleteCarRequest deleteCarRequest) {
		carBusinessRules.checkIfCarIdExists(deleteCarRequest.getId());
		Car car = this.modelMapperService.forRequest().map(deleteCarRequest, Car.class);
		this.carRepository.delete(car);

	}

	@Override
	public void updateCar(UpdateCarRequest updateCarRequest) {

		carBusinessRules.checkIfCarIdExists(updateCarRequest.getId());
		carBusinessRules.checkIfCarPlateExists(updateCarRequest.getPlate());
		
		Car car = this.modelMapperService.forRequest().map(updateCarRequest,Car.class);
		this.carRepository.save(car);

	}

	@Override
	public List<GetAllCarResponse> getAll() {

		List<Car> cars = carRepository.findAll();

		List<GetAllCarResponse> carResponses = cars.stream()
				.map(car -> this.modelMapperService.forResponse().map(car, GetAllCarResponse.class))
				.collect(Collectors.toList());

		return carResponses;

	}

	@Override
	public GetByIdCarResponse getByIdCar(int id) {

		Car car = this.carRepository.findById(id).orElseThrow();
		GetByIdCarResponse getByIdCarResponse = this.modelMapperService.forResponse().map(car,
				GetByIdCarResponse.class);

		return getByIdCarResponse;
	}

}
