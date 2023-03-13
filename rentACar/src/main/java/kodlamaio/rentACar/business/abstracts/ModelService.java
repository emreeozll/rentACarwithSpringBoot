package kodlamaio.rentACar.business.abstracts;

import java.util.List;

import kodlamaio.rentACar.business.requests.CreateModelRequest;
import kodlamaio.rentACar.business.requests.DeleteModelRequest;
import kodlamaio.rentACar.business.requests.UpdateModelRequest;
import kodlamaio.rentACar.business.responses.GetAllModelsResponse;
import kodlamaio.rentACar.business.responses.GetByIdModelResponse;

public interface ModelService {

	void add(CreateModelRequest createModelRequest);

	void delete(DeleteModelRequest deleteModelRequest);

	void update(UpdateModelRequest updateModelRequest);

	List<GetAllModelsResponse> getAll();

	GetByIdModelResponse getByModelId(int id);

}
