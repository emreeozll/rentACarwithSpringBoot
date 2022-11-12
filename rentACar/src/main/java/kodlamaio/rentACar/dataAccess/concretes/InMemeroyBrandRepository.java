package kodlamaio.rentACar.dataAccess.concretes;


import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import kodlamaio.rentACar.dataAccess.abstracts.BrandRepository;
import kodlamaio.rentACar.entities.concretes.Brand;

//bu sinif bir dataAccess nesnesidir
@Repository 
public class InMemeroyBrandRepository implements BrandRepository {

//Arraylist, List interface sinifindan tureyen bir alt sinif. Onu implement etmektedir.
// birbirlerinin referanslarini tutabildikleri icin arraylist'i referans verdik.
// Globalde tanımladık ki metod erissin
// Örnek yazım 1-) List<Brand> brands = new ArrayList<Brand>();

	List<Brand> brands;

	// new'lendiğinde (yeni nesne olustugunda) çalışacak constructor blogu
	public InMemeroyBrandRepository() {
         brands = new ArrayList<Brand>();
		brands.add(new Brand(1, "Audi"));
		brands.add(new Brand(2, "Bmw"));
		brands.add(new Brand(3, "Renault"));

	}

	@Override
	public List<Brand> getAll() {

		return brands;
	}

}
