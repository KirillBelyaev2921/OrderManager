package belyaev.order.OrderManager.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column(name = "category_name", length = 50, nullable = false)
    private String categoryName;

    @OneToMany(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "product_category_id")
    private List<Product> products;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_category_id", nullable = false)
    @JsonIgnore
    private User userCategories;

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", categoryName='" + categoryName + '\'' +
                ", products=" + products +
                ", user=" + userCategories.getUserId() +
                '}';
    }
}
