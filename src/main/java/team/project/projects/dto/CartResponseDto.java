package team.project.projects.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import team.project.projects.entity.CartEntity;
import team.project.projects.entity.CategoryEntity;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartResponseDto {
	private int num;
	private String productName;
	private int price;
	private int count;
	private String image;
	private String id;
	
	public CartResponseDto(CartEntity cartDto) {
		this.productName = cartDto.getProductName();
		this.price = cartDto.getPrice();
		this.count = cartDto.getCount();
		this.image = "http://localhost:4040/file/" + cartDto.getImage();
		this.id = cartDto.getId();
		

}
}