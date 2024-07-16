package gift.dto;

import gift.domain.Product;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UpdateProductDto {
    @NotBlank
    @Size(min = 1, max = 15)
    @Pattern(regexp = "^[a-zA-Z0-9\\s()\\[\\]+\\-&/\\_]*$", message = "허용된 특수 문자는 (, ), [, ], +, -, &, /, _ 입니다.")
    @Pattern(regexp = "^(?!.*카카오).*$", message = "\"카카오\"가 포함된 상품명은 사용할 수 없습니다.")
    String name;
    Integer price;
    String imageUrl;

    public String getName() {
        return this.name;
    }

    public void updateProduct(Product product) {
        product.setName(this.name);
        product.setPrice(this.price);
        product.setImageUrl(this.imageUrl);
    }
}