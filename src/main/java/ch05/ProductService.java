package ch05;

import java.util.*;

public class ProductService {
  Map<String,Product> products = new HashMap<>();

  public ProductService() {
    Product p1 = new Product("101","갤럭시","삼성",100,"2023-10-19");
    products.put("101",p1);
    Product p2 = new Product("102","초콜렛","엘지",150,"2023-10-19");
    products.put("102",p2);
    Product p3 = new Product("103","폴더블","삼성",1000,"2023-10-19");
    products.put("103",p3);
  }

  public List<Product> findAll() {
    return new ArrayList<>(products.values());
  }

  public Product findById(String id) {
    return products.get(id);
  }
}
