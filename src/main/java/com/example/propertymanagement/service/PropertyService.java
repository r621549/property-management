package com.example.propertymanagement.service;

import com.example.propertymanagement.dto.PropertyDTO;
import java.util.List;

public interface PropertyService {
    PropertyDTO saveProperty(PropertyDTO propertyDTO);
    List<PropertyDTO> getAllProperties();
    PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId);

    PropertyDTO updateDescription(PropertyDTO propertyDTO, Long propertyId);
    PropertyDTO updatePrice(PropertyDTO propertyDTO, Long propertyId);

    void deleteProperty(Long propertyId);
}
