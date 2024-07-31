import com.example.inventorymanagement.model.Product;
import com.example.inventorymanagement.repository.InMemoryProductRepository;
import com.example.inventorymanagement.repository.ProductRepository;
import com.example.inventorymanagement.service.ProductService;

import java.util.List;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ProductRepository productRepository = new InMemoryProductRepository();
        ProductService productService = new ProductService(productRepository);

        Product product1 = productService.createProduct("Laptop", 1200.00);
        Product product2 = productService.createProduct("Smartphone", 800.00);

        List<Product> products = productService.getAllProducts();
        System.out.println("Todos los productos: " + products);

        Optional<Product> product = productService.getProductById(product1.getId());
        if (product.isPresent()) {
            System.out.println("El producto encontrado: " + product);
        }

        Product updatedProduct = productService.updateProductById(product1.getId(), "Laptop HP", 950.00);
        System.out.println("El producto aztualizado: " + updatedProduct);

        productService.deleteProductById(product2.getId());
        System.out.println("Producto eliminado: " + product2);

        products = productService.getAllProducts();
        System.out.println("Todos los productos: " + products);
    }
}