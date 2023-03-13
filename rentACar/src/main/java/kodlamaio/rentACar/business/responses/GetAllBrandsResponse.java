package kodlamaio.rentACar.business.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllBrandsResponse {
// gelen isteklere cevap vereceğimiz yer
//	request - response tasarim - tüm verilerimi özel veya önemli olanlarida farkinda olmadan paylaşmamak icin
	private int id;
	private String name;
}
