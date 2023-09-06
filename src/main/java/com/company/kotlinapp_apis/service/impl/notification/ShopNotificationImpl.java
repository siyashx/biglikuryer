package com.company.kotlinapp_apis.service.impl.notification;

import com.company.kotlinapp_apis.dao.notification.ShopNotificationRepository;
import com.company.kotlinapp_apis.dto.notification.ShopNotificationDto;
import com.company.kotlinapp_apis.model.notification.ShopNotification;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShopNotificationImpl {
    
    private final ShopNotificationRepository shopNotificationRepository;
    private final ModelMapper modelMapper;

    public ShopNotificationImpl(ShopNotificationRepository shopNotificationRepository, ModelMapper modelMapper) {
        this.shopNotificationRepository = shopNotificationRepository;
        this.modelMapper = modelMapper;
    }

    //ALL
    public List<ShopNotificationDto> getAllShopNotification() {
        List<ShopNotification> list = shopNotificationRepository.findAll();
        return list.stream()
                .map(det -> modelMapper.map(det, ShopNotificationDto.class))
                .toList();
    }

    //ById
    public ShopNotificationDto getShopNotificationById(Long id) {
        Optional<ShopNotification> optional = shopNotificationRepository.findById(id);
        return optional.map(det -> modelMapper.map(det, ShopNotificationDto.class)).orElse(null);
    }

    //Save
    public ShopNotificationDto saveShopNotification(ShopNotificationDto dto) {
        ShopNotification det = modelMapper.map(dto, ShopNotification.class);
        det = shopNotificationRepository.save(det);
        return modelMapper.map(det, ShopNotificationDto.class);
    }

    //Delete
    public Boolean deleteShopNotification(Long id) {
        Optional<ShopNotification> optional = shopNotificationRepository.findById(id);
        if (optional.isPresent()) {
            ShopNotification det = optional.get();
            shopNotificationRepository.delete(det);
            return true;
        }
        return false;
    }
}
