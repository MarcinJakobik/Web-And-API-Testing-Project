package com.sparta.badgerBytes.tests;

import com.sparta.badgerBytes.testFramework.controll.*;
import com.sparta.badgerBytes.testFramework.model.*;
import com.sparta.badgerBytes.testFramework.model.dto.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class InjectorTests {

    public static ProductListDTO productListDTO;
    public static BrandListDTO brandListDTO;
    public static UserAccountDTO userAccountDTO;
    public static UserCredentialsDTO userCredentialsDTO;

    @Test
    @DisplayName("Check that the deserialize method will return an appropriate Java object")
    void checkThatTheDeserializeMethodWillReturnAnAppropriateJavaObject() {
        //Arrange
        productListDTO = new ProductListDTO();
        brandListDTO = new BrandListDTO();
        userAccountDTO = new UserAccountDTO();
        userCredentialsDTO = new UserCredentialsDTO();
        //Act
        productListDTO = (ProductListDTO) Injector.deserialize(productListDTO, ConnectionManager.Method.GET,"productsList");
        brandListDTO = (BrandListDTO) Injector.deserialize(brandListDTO, ConnectionManager.Method.GET,"brandsList");
        userAccountDTO = (UserAccountDTO) Injector.deserialize(userAccountDTO, ConnectionManager.Method.GET,"getUserDetailByEmail");
        userCredentialsDTO = (UserCredentialsDTO) Injector.deserialize(userCredentialsDTO, ConnectionManager.Method.GET,"verifyLogin");
        //Assert
        assertInstanceOf(ProductListDTO.class, productListDTO);
        assertInstanceOf(BrandListDTO.class, brandListDTO);
        assertInstanceOf(UserAccountDTO.class, userAccountDTO);
        assertInstanceOf(UserCredentialsDTO.class, userCredentialsDTO);
    }
}