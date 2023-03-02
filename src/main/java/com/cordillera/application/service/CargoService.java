package com.cordillera.application.service;

import com.cordillera.application.mapper.CargoMapper;
import com.cordillera.application.repository.jpa.CargoRepository;
import com.cordillera.domain.dto.CargoDto;
import com.cordillera.domain.excepcion.CargoException;
import com.cordillera.domain.models.Cargo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CargoService {

    //TODO AJUSTAR LA INYECCION DE DEPENDCIA SI POR CONTRUCTOR O POR CAMPOS
    //TODO https://http.cat/
    private final CargoMapper cargoMapper;
    private final CargoRepository cargoRepository;

    //Metodo para guardar un cargo
    public CargoDto saveCargo(CargoDto cargoDto) throws CargoException{
        //TODO VALIDACIONES
        //TODO VALIDAR CARGO NO EXISTA
        //TODO METODO NO HACE NADA GUARDAR EN BASE DE DATOS
        //TODO realizar excepcion personalizada
        Cargo cargoValidacionNombre = cargoRepository.findCargoByNombreCargo(cargoDto.getNombreCargo()).orElse(null);
        if(cargoValidacionNombre != null){
            throw new CargoException("Cargo ya existe en el sistema");
        }
        return cargoMapper.cargoModelToCargoDTO(cargoRepository.save(cargoMapper.cargoDTOToCargoModel(cargoDto)));
    }

    //Metodo para actualizar un cargo
    public CargoDto updateCargo(CargoDto cargoDto) throws CargoException{
        //TODO VALIDACIONES
        //TODO VALIDAR DESCRIOCION NO EXISTA
        //TODO realizar excepcion personalizada
        Cargo cargoValidacionNombre = cargoRepository.findCargoByNombreCargo(cargoDto.getNombreCargo()).orElse(null);
        if(cargoValidacionNombre == null){
            throw new CargoException("No se puede tener cargos sin nombre");
        }
        return cargoMapper.cargoModelToCargoDTO(cargoRepository.save(cargoMapper.cargoDTOToCargoModel(cargoDto)));
    }

    //Metodo para eliminar un cargo
    public void deleteCargo(Long cargoId) throws CargoException{
        //TODO VALIDACIONES REGISTRO BORRAR EXISTA
        //TODO realizar excepcion personalizada
        Cargo cargoValidacionId = cargoRepository.findById(cargoId).orElse(null);
        if(cargoValidacionId == null){
            throw new CargoException("Debe seleccionar al menos un cargo");
        }
        cargoRepository.deleteById(cargoId);
    }

    //Metodo para listar un cargo
    public List<CargoDto> listCargo() throws CargoException{
        List<Cargo> listaCargos = cargoRepository.findAll();
        List<CargoDto> cargosDTO = new ArrayList<>();

        if(listaCargos.isEmpty()){
            //TODO realizar excepcion personalizada
            throw new RuntimeException("No hay cargos en el sistema");
        }

        for(Cargo lCargo: listaCargos){
            cargosDTO.add(cargoMapper.cargoModelToCargoDTO(lCargo));
        }

        return cargosDTO;
    }

    //TODO METODO PARA CONSULTAR POR ID
    public CargoDto findById(Long cargoId) throws CargoException{
        Cargo cargoValidacionId = cargoRepository.findById(cargoId).orElse(null);
        if(cargoValidacionId == null){
            throw new CargoException("Cargo no existe en el sistema");
        }
        return cargoMapper.cargoModelToCargoDTO(cargoRepository.findById(cargoId).get());
    }

    //TODO METODO PARA CONSULTAR POR DESCRIPCION
    public CargoDto findByNombre(String nombreCargo) throws CargoException{
        Cargo cargoValidacionNombre = cargoRepository.findCargoByNombreCargo(nombreCargo).orElse(null);
        if(cargoValidacionNombre == null){
            throw new CargoException("El campo nombre se encuentra vacio o no existe en el sistema");
        }
        return cargoMapper.cargoModelToCargoDTO(cargoRepository.findCargoByNombreCargo(nombreCargo).get());
    }
}
