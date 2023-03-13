package kodlamaio.rentACar.webApi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.rentACar.business.abstracts.BrandService;
import kodlamaio.rentACar.business.requests.CreateBrandRequest;
import kodlamaio.rentACar.business.requests.DeleteBrandRequest;
import kodlamaio.rentACar.business.requests.UpdateBrandsRequest;
import kodlamaio.rentACar.business.responses.GetAllBrandsResponse;
import kodlamaio.rentACar.business.responses.GetByIdBrandResponse;
import lombok.AllArgsConstructor;

@RestController // Annotation  bu sinif bir controller nesnesidir
@RequestMapping("api/brands")
@AllArgsConstructor
public class BrandsController {

	private BrandService brandService;

	
	@GetMapping()
	public List<GetAllBrandsResponse> getAll(){
		return brandService.getAll();
	}
	
	@GetMapping("/{id}")
	public GetByIdBrandResponse getByModelId(@PathVariable int id) {
		return brandService.getByBrandId(id);
	}
	
	 @PostMapping("/add")
	 @ResponseStatus(code=HttpStatus.CREATED) //201 (200 - Başarılı/Tamam. 201 - Oluşturuldu. 202 - Kabul edildi/Onaylandı)
	 public void add(@Valid() @RequestBody CreateBrandRequest brandRequest) {
		 this.brandService.add(brandRequest);
	 }

	 
	 @PutMapping("/update")
	 @ResponseStatus(code = HttpStatus.OK)
	 public void update(@Valid() @RequestBody UpdateBrandsRequest brandsRequest) {
		 this.brandService.update(brandsRequest);
	 }
	 
	 @DeleteMapping("/delete")
	 @ResponseStatus(code=HttpStatus.OK)
	 public void delete(@Valid() @RequestBody DeleteBrandRequest deleteBrandRequest) {
		
		 this.brandService.delete(deleteBrandRequest);
		 
	 }
	 
	 
	 
	 
	 
	 
}
