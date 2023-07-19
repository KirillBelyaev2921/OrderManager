package belyaev.order.OrderManager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(name = "product_name", length = 50, nullable = false)
    private String productName;
    @Column(name = "product_amount", length = 10, nullable = false)
    private int productAmount;
    @Column(name = "product_details")
    private String productDetails;

    @ManyToOne(optional = false)
    @JoinColumn(name = "product_category_id", nullable = false)
    @JsonIgnore
    private Category categoryOfProducts;

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productAmount=" + productAmount +
                ", productDetails='" + productDetails + '\'' +
                ", categoryOfProducts=" + categoryOfProducts.getCategoryName() +
                '}';
    }
}
