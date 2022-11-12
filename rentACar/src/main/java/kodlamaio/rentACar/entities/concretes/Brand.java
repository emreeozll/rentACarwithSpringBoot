package kodlamaio.rentACar.entities.concretes;

public class Brand {

//	Brand --> marka 
//	entities --> veritabani nesnelerini tutarız.
//	concretes --> somust classlar tutulacak
// abstarcts --> soyut sınıflar tutulacak	amac gruplama yapmak.

	// veritabani tasarimin tablo tasarimi kurallari
	private int id;
	private String name;

	public Brand() {

	}

	public Brand(int id, String name) {

		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
