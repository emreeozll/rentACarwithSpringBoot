package kodlamaio.rentACar.business.abstracts;

import java.util.List;

import kodlamaio.rentACar.business.requests.CreateModelRequest;
import kodlamaio.rentACar.business.requests.DeleteModelRequest;
import kodlamaio.rentACar.business.requests.UpdateModelRequest;
import kodlamaio.rentACar.business.responses.GetAllModelsResponse;
import kodlamaio.rentACar.business.responses.GetByIdModelResponse;

public interface ModelService {

	public void addModel(CreateModelRequest createModelRequest);

	public void deleteModel(DeleteModelRequest deleteModelRequest);

	public void updateModel(UpdateModelRequest updateModelRequest);

	public List<GetAllModelsResponse> getAll();

	public GetByIdModelResponse getByModelId(int id);

}
