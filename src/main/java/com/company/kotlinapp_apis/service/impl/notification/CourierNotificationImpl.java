package com.company.kotlinapp_apis.service.impl.notification;

import com.company.kotlinapp_apis.dao.notification.CourierNotificationRepository;
import com.company.kotlinapp_apis.dto.notification.CourierNotificationDto;
import com.company.kotlinapp_apis.model.notification.CourierNotification;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourierNotificationImpl {
    
    private final CourierNotificationRepository courierNotificationRepository;
    private final ModelMapper modelMapper;

    public CourierNotificationImpl(CourierNotificationRepository courierNotificationRepository, ModelMapper modelMapper) {
        this.courierNotificationRepository = courierNotificationRepository;
        this.modelMapper = modelMapper;
    }

    //ALL
    public List<CourierNotificationDto> getAllCourierNotification() {
        List<CourierNotification> list = courierNotificationRepository.findAll();
        return list.stream()
                .map(det -> modelMapper.map(det, CourierNotificationDto.class))
                .toList();
    }

    //ById
    public CourierNotificationDto getCourierNotificationById(Long id) {
        Optional<CourierNotification> optional = courierNotificationRepository.findById(id);
        return optional.map(det -> modelMapper.map(det, CourierNotificationDto.class)).orElse(null);
    }

    //Save
    public CourierNotificationDto saveCourierNotification(CourierNotificationDto dto) {
        CourierNotification det = modelMapper.map(dto, CourierNotification.class);
        det = courierNotificationRepository.save(det);
        return modelMapper.map(det, CourierNotificationDto.class);
    }

    //Delete
    public Boolean deleteCourierNotification(Long id) {
        Optional<CourierNotification> optional = courierNotificationRepository.findById(id);
        if (optional.isPresent()) {
            CourierNotification det = optional.get();
            courierNotificationRepository.delete(det);
            return true;
        }
        return false;
    }
}
