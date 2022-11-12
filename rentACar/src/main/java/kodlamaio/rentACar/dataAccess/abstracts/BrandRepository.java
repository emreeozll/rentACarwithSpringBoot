package kodlamaio.rentACar.dataAccess.abstracts;

import java.util.List;

import kodlamaio.rentACar.entities.concretes.Brand;

public interface BrandRepository {

//repository - veritabani islemlerini yapacak siniflara verilen isimdir. Örnek: ....Dao, ...Repository

	List<Brand> getAll();

}
