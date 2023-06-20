package com.company.kotlinapp_apis.api.shop.controller;

import com.company.kotlinapp_apis.dto.courier.CourierDto;
import com.company.kotlinapp_apis.dto.shop.ShopDto;
import com.company.kotlinapp_apis.service.impl.shop.ShopServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/shops")
public class ShopRegisterController {

    private final ShopServiceImpl shopServiceImpl;

    public ShopRegisterController(ShopServiceImpl shopServiceImpl) {
        this.shopServiceImpl = shopServiceImpl;
    }

    //CREATE
    @PostMapping
    public ResponseEntity<ShopDto> createShop(@RequestBody ShopDto shopDto){
        return shopServiceImpl.createShop(shopDto);
    }

    //LIST
    @GetMapping
    public List<ShopDto> getAllShops(){
        return shopServiceImpl.getAllShops();
    }

    //ID
    @GetMapping("/{shopId}")
    public ResponseEntity<?> getShopById(@PathVariable("shopId") Long shopId){
        ShopDto shopDto = shopServiceImpl.getShopById(shopId);
        if (shopDto != null) {
            return ResponseEntity.ok(shopDto);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("shop doesn't exist with given id..");
    }

}
