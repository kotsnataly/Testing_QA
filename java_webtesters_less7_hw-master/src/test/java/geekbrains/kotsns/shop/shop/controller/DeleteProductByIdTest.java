package geekbrains.kotsns.shop.shop.controller;

import geekbrains.kotsns.shop.shop.repository.ProductsRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class AddProductToCartTest {
    @Autowired
    private ProductsRepository productsRepository;
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void addProductToCart() throws Exception {
        MvcResult mvcResult = this.mockMvc.perform(post("/addToCart")
                .content("{\"productId\": 11,\"customerId\": 6}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assertions.assertTrue(Boolean.parseBoolean(mvcResult.getResponse().getContentAsString()));

    }

}