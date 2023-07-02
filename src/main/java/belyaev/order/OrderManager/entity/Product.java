package belyaev.order.OrderManager.entity;

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
    private Long id;
    @Column(name="product_name", length=50, nullable=false)
    private String productName;
    @Column(name="product_amount", length=10, nullable=false)
    private int productAmount;
    @Column(name="product_details")
    private String productDetails;
}
