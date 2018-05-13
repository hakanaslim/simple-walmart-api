package com.deolitte.simplewalmartapi;

import com.deolitte.simplewalmartapi.model.ProductDto;
import com.deolitte.simplewalmartapi.model.SearchQueryDto;
import com.deolitte.simplewalmartapi.service.ProductService;
import com.deolitte.simplewalmartapi.service.ProductServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@SpringBootTest
@WebAppConfiguration
public class ProductServiceTest {

    @TestConfiguration
    public static class EmployeeServiceImplTestContextConfiguration {

        @Value("${walmart.api-key}")
        public String walmartApiKey;

        @Value("${walmart.api-format}")
        public String walmartApiFormat;

        @Value("${walmart.url}")
        public String walmartURL;

        @Bean
        public ProductService productService() {
            ProductServiceImpl productService = new ProductServiceImpl();
            productService.setWalmartURL(walmartURL);
            productService.setWalmartApiFormat(walmartApiFormat);
            productService.setWalmartApiKey(walmartApiKey);
            return productService;
        }
    }

    @Autowired
    private ProductService productService;

    @Test
    public void getProducts() {
        SearchQueryDto productQuery = productService.getProducts();

        Assert.assertNotNull(productQuery);

        Assert.assertTrue(productQuery.getItems().size() > 0);
    }

    @Test
    public void getAProduct() {
        SearchQueryDto searchQuery = productService.getProducts();

        Assert.assertNotNull(searchQuery);

        Assert.assertTrue(searchQuery.getItems().size() > 0);

        ProductDto product = productService.getProductByItemId(searchQuery.getItems().iterator().next().getItemId());

        Assert.assertNotNull(product);

        Assert.assertTrue(product.getItemId() > 0);
    }

}
