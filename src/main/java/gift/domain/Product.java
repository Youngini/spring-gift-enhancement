package gift.domain;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long product_id;

    @Column(nullable = false, length = 15)
    private String name;

    @Column(nullable = false)
    private Integer price;

    @Column(nullable = false)
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Wish> wishes = new ArrayList<>();

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true )
    private List<Option> options = new ArrayList<>();

    public Product(String name, int price, String imageUrl, Category category) {
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public Product update(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.imageUrl = product.getImageUrl();
        this.category = product.getCategory();
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(Integer price) {
        this.price = price;
    }
    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
    public void setCategory(Category category) { this.category = category; }

    public Long getId() {
        return product_id;
    }
    public String getName() {
        return name;
    }
    public Integer getPrice() {
        return price;
    }
    public String getImageUrl() {
        return imageUrl;
    }
    public Category getCategory() {return category;}

    public void setOptions(List<Option> optionList) {
        this.options = optionList;
    }

    public List<Option> getOption() {
        return options;
    }
}
