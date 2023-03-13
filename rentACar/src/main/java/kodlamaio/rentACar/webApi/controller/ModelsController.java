package kodlamaio.rentACar.webApi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.rentACar.business.abstracts.ModelService;
import kodlamaio.rentACar.business.requests.CreateModelRequest;
import kodlamaio.rentACar.business.requests.DeleteModelRequest;
import kodlamaio.rentACar.business.requests.UpdateModelRequest;
import kodlamaio.rentACar.business.responses.GetAllModelsResponse;
import kodlamaio.rentACar.business.responses.GetByIdModelResponse;
import lombok.AllArgsConstructor;

@RestController // Annotation bu sinif bir controller nesnesidir
@RequestMapping("api/models")
@AllArgsConstructor
public class ModelsController {

	private final ModelService modelService;


	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@Valid() CreateModelRequest createModelRequest) {
		this.modelService.add(createModelRequest);
	}
	
	@DeleteMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void delete(@Valid() DeleteModelRequest deleteModelRequest) {
	   this.modelService.delete(deleteModelRequest);	
	}
	
	@PutMapping
	@ResponseStatus(code = HttpStatus.OK)
	public void update(@Valid() UpdateModelRequest updateModelRequest) {
		this.modelService.update(updateModelRequest);
	}
	
	@GetMapping
	public List<GetAllModelsResponse> getAll() {

		return this.modelService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdModelResponse getByModelId(@PathVariable int id) {
		return  modelService.getByModelId(id) ;
	    	
    }
	
	
	
	
	
}
