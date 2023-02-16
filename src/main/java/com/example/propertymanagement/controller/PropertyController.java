package com.example.propertymanagement.controller;

import com.example.propertymanagement.dto.PropertyDTO;
import com.example.propertymanagement.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PropertyController {

    @Autowired
    private PropertyService propertyService;

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @PostMapping("/properties")
    public ResponseEntity<PropertyDTO> saveProperty(@RequestBody PropertyDTO propertyDTO){
        return new ResponseEntity<PropertyDTO>(propertyService.saveProperty(propertyDTO), HttpStatus.CREATED);
    }

    @GetMapping("/properties")
    public ResponseEntity<List<PropertyDTO>> getProperties(){
        return new ResponseEntity<List<PropertyDTO>>(propertyService.getAllProperties(), HttpStatus.OK);
    }

    @PutMapping("/properties/{propertyId}")
    public ResponseEntity<PropertyDTO> updateProperty(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        PropertyDTO dto = propertyService.updateProperty(propertyDTO, propertyId);
        if(dto != null){
            return new ResponseEntity<PropertyDTO>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<PropertyDTO>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/properties/{propertyId}/description")
    public ResponseEntity<PropertyDTO> updateDescription(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        PropertyDTO dto = propertyService.updateDescription(propertyDTO, propertyId);
        if(dto != null){
            return new ResponseEntity<PropertyDTO>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<PropertyDTO>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/properties/{propertyId}/price")
    public ResponseEntity<PropertyDTO> updatePrice(@RequestBody PropertyDTO propertyDTO, @PathVariable Long propertyId){
        PropertyDTO dto = propertyService.updatePrice(propertyDTO, propertyId);
        if(dto != null){
            return new ResponseEntity<PropertyDTO>(dto, HttpStatus.OK);
        }
        return new ResponseEntity<PropertyDTO>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/properties/{propertyId}")
    public ResponseEntity<Void> deleteProperty( @PathVariable Long propertyId){
        propertyService.deleteProperty(propertyId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
