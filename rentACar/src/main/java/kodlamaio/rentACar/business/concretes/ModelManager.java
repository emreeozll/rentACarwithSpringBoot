package kodlamaio.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlamaio.rentACar.business.abstracts.ModelService;
import kodlamaio.rentACar.business.requests.CreateModelRequest;
import kodlamaio.rentACar.business.requests.DeleteModelRequest;
import kodlamaio.rentACar.business.requests.UpdateModelRequest;
import kodlamaio.rentACar.business.responses.GetAllModelsResponse;
import kodlamaio.rentACar.business.responses.GetByIdModelResponse;
import kodlamaio.rentACar.business.rules.ModelBusinessRules;
import kodlamaio.rentACar.core.utilities.mappers.ModelMapperService;
import kodlamaio.rentACar.dataAccess.abstracts.ModelRepository;
import kodlamaio.rentACar.entities.concretes.Model;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ModelManager implements ModelService {

	private ModelRepository modelRepository;
	private ModelMapperService mapperService;
	private ModelBusinessRules modelBusinessRules;

	@Override
	public void add(CreateModelRequest createModelRequest) {

		this.modelBusinessRules.checkIfModelNameExists(createModelRequest.getName());
		Model model = this.mapperService.forRequest().map(createModelRequest, Model.class);
		this.modelRepository.save(model);

	}

	@Override
	public void delete(DeleteModelRequest deleteModelRequest) {

		this.modelBusinessRules.checkIfModelIdExists(deleteModelRequest.getId());
		Model model = this.mapperService.forRequest().map(deleteModelRequest, Model.class);
		this.modelRepository.delete(model);

	}

	@Override
	public void update(UpdateModelRequest updateModelRequest) {

		this.modelBusinessRules.checkIfModelIdExists(updateModelRequest.getId());
		Model model = this.mapperService.forRequest().map(updateModelRequest, Model.class);
		this.modelRepository.save(model);

	}

	@Override
	public List<GetAllModelsResponse> getAll() {

		// ModelMapper brandName'i eşleştirirken brand kelimesini arayaarak nesneye denk
		// gelir, oradan nesneye giriş yapar
		// Nesnenin kendi field özelliklerinden name alır. Bizim için join atar.

		List<Model> models = modelRepository.findAll();

		List<GetAllModelsResponse> modelsResponse = models.stream()
				.map(model -> this.mapperService.forResponse().map(model, GetAllModelsResponse.class))
				.collect(Collectors.toList());
		return modelsResponse;
	}

	@Override
	public GetByIdModelResponse getByModelId(int id) {

		Model model = this.modelRepository.findById(id).orElseThrow();
		GetByIdModelResponse getByIdModelResponse = this.mapperService.forResponse().map(model,
				GetByIdModelResponse.class);

		return getByIdModelResponse;
	}

}
