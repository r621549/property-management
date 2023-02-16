package com.example.propertymanagement.service;

import com.example.propertymanagement.converter.PropertyConverter;
import com.example.propertymanagement.dto.PropertyDTO;
import com.example.propertymanagement.entity.PropertyEntity;
import com.example.propertymanagement.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PropertyServiceImpl implements PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;
    @Autowired
    private PropertyConverter propertyConverter;

    @Override
    public PropertyDTO saveProperty(PropertyDTO propertyDTO){

        PropertyEntity entity = propertyConverter.convertDtoToEntity(propertyDTO);
        entity = propertyRepository.save(entity);
        return propertyConverter.convertEntityToDto(entity);
    }

    @Override
    public List<PropertyDTO> getAllProperties() {
        List<PropertyEntity> entities = (List<PropertyEntity>) propertyRepository.findAll();
        return propertyConverter.convertEntitiesToDtos(entities);
    }

    /**
     * @param propertyDTO
     * @param propertyId
     * @return
     */
    @Override
    public PropertyDTO updateProperty(PropertyDTO propertyDTO, Long propertyId) {

        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);
        if(optionalPropertyEntity.isPresent()){
            PropertyEntity entity = propertyConverter.convertDtoToEntity(propertyDTO);
            entity.setId(propertyId);
            entity = propertyRepository.save(entity);
            propertyDTO = propertyConverter.convertEntityToDto(entity);
            return propertyDTO;
        }
        return null;
    }

    /**
     * @param propertyDTO
     * @param propertyId
     * @return
     */
    @Override
    public PropertyDTO updateDescription(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);
        if(optionalPropertyEntity.isPresent()){
            PropertyEntity entity = optionalPropertyEntity.get();
            entity.setDescription(propertyDTO.getDescription());
            entity = propertyRepository.save(entity);
            propertyDTO = propertyConverter.convertEntityToDto(entity);
            return propertyDTO;
        }
        return null;
    }
    @Override
    public PropertyDTO updatePrice(PropertyDTO propertyDTO, Long propertyId) {
        Optional<PropertyEntity> optionalPropertyEntity = propertyRepository.findById(propertyId);
        if(optionalPropertyEntity.isPresent()){
            PropertyEntity entity = optionalPropertyEntity.get();
            entity.setPrice(propertyDTO.getPrice());
            entity = propertyRepository.save(entity);
            propertyDTO = propertyConverter.convertEntityToDto(entity);
            return propertyDTO;
        }
        return null;
    }

    /**
     * @param propertyId
     */
    @Override
    public void deleteProperty(Long propertyId) {
        propertyRepository.deleteById(propertyId);
    }

}
