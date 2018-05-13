package com.deolitte.simplewalmartapi;

import com.deolitte.simplewalmartapi.controller.ProductController;
import com.deolitte.simplewalmartapi.model.ProductDto;
import com.deolitte.simplewalmartapi.service.ProductService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@RunWith(SpringRunner.class)
@WebMvcTest(ProductController.class)
public class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private ProductService productService;

    @Test
    public void getProducts() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/product")
                .contentType(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void getProduct() throws Exception {
        ProductDto product = new ProductDto();
        product.setItemId(1L);

        BDDMockito.given(productService.getProductByItemId(1)).willReturn(product);

        mvc.perform(MockMvcRequestBuilders.get("/product/1")
                .contentType(APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().string("{\"itemId\":1}"));
    }

}
