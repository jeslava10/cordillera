package com.cordillera.application.service;

import com.cordillera.application.mapper.CargoMapper;
import com.cordillera.application.repository.jpa.CargoRepository;
import com.cordillera.domain.dto.CargoDto;
import com.cordillera.domain.models.Cargo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CargoService {

    //TODO AJUSTAR LA INYECCION DE DEPENDCIA SI POR CONTRUCTOR O POR CAMPOS
    //TODO https://http.cat/
    @Autowired
    private final CargoMapper cargoMapper;

    @Autowired
    private final CargoRepository cargoRepository;

    //Metodo para guardar un cargo
    public CargoDto saveCargo(CargoDto cargoDto){
        //TODO VALIDACIONES
        //TODO VALIDAR CARGO NO EXISTA
        //TODO METODO NO HACE NADA GUARDAR EN BASE DE DATOS
        //TODO realizar excepcion personalizada
        return cargoDto;
    }

    //Metodo para actualizar un cargo
    public CargoDto updateCargo(CargoDto cargoDto){
        //TODO VALIDACIONES
        //TODO VALIDAR DESCRIOCION NO EXISTA
        //TODO realizar excepcion personalizada
        return cargoMapper.cargoModelToCargoDTO(cargoRepository.save(cargoMapper.cargoDTOToCargoModel(cargoDto)));
    }

    //Metodo para eliminar un cargo
    public void deleteCargo(Long cargoId){
        //TODO VALIDACIONES REGISTRO BORRAR EXISTA
        //TODO realizar excepcion personalizada
        cargoRepository.deleteById(cargoId);
    }

    //Metodo para listar un cargo
    public List<CargoDto> listCargo(){
        List<Cargo> listaCargos = cargoRepository.findAll();
        List<CargoDto> cargosDTO = new ArrayList<>();

        if(listaCargos.isEmpty()){
            //TODO realizar excepcion personalizada
        }

        for(Cargo lCargo: listaCargos){
            cargosDTO.add(cargoMapper.cargoModelToCargoDTO(lCargo));
        }

        return cargosDTO;
        //return listaCargos.stream().map(cargoMapper::cargoModelToCargoDTO).collect(Collectors.toList());
    }

    //TODO METODO PARA CONSULTAR POR ID

    //TODO METODO PARA CONSULTAR POR DESCRIPCION
}
