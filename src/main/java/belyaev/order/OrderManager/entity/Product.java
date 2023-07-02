package belyaev.order.OrderManager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String productName;
    private int productCount;
    private String productDetails;
}
