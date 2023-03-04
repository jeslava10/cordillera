package com.cordillera.application.service;

import com.cordillera.application.mapper.CargoMapper;
import com.cordillera.application.repository.jpa.CargoRepository;
import com.cordillera.application.resources.MensajesErrores;
import com.cordillera.domain.dto.CargoDto;
import com.cordillera.domain.dto.CargoPostDto;
import com.cordillera.domain.excepcion.CargoException;
import com.cordillera.domain.models.Cargo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CargoService {

    private final CargoMapper cargoMapper;
    private final CargoRepository cargoRepository;

    //Metodo para guardar un cargo
    public CargoDto saveCargo(CargoPostDto cargoPostDto){

        if(cargoRepository.findCargoByNombreCargo(cargoPostDto.getNombreCargo()).isPresent()){
            throw new CargoException(MensajesErrores.CARGO_YA_REGISTRADO.getValue());
        }

        Cargo cargo = new Cargo();
        try {
            cargo.setNombreCargo(cargoPostDto.getNombreCargo());
            cargo.setIdCargo(null);
            cargo = cargoRepository.save(cargo);
        }catch (Exception e){
            throw new CargoException(e.getMessage());
        }
        return cargoMapper.cargoModelToCargoDTO(cargo);
    }

    //Metodo para actualizar un cargo
    public CargoDto updateCargo(CargoDto cargoDto) throws CargoException{

        if(!cargoRepository.findCargoByNombreCargo(cargoDto.getNombreCargo()).isPresent()){
            throw new CargoException("No se puede tener cargos sin nombre");
        }
        return cargoMapper.cargoModelToCargoDTO(cargoRepository.save(cargoMapper.cargoDTOToCargoModel(cargoDto)));
    }

    //Metodo para eliminar un cargo
    public void deleteCargo(Long cargoId) throws CargoException{

        if(!cargoRepository.findById(cargoId).isPresent()){
            throw new CargoException("Debe seleccionar al menos un cargo");
        }
        cargoRepository.deleteById(cargoId);
    }

    //Metodo para listar un cargo
    public List<CargoDto> listCargo() throws CargoException{
        List<Cargo> listaCargos = cargoRepository.findAll();
        List<CargoDto> cargosDTO = new ArrayList<>();

        if(listaCargos.isEmpty()){

            throw new CargoException("No hay cargos en el sistema");
        }

        for(Cargo lCargo: listaCargos){
            cargosDTO.add(cargoMapper.cargoModelToCargoDTO(lCargo));
        }

        return cargosDTO;
    }

    public CargoDto findById(Long cargoId) throws CargoException{

        if(!cargoRepository.findById(cargoId).isPresent()){
            throw new CargoException("Cargo no existe en el sistema");
        }
        return cargoMapper.cargoModelToCargoDTO(cargoRepository.findById(cargoId).get());
    }

    public CargoDto findByNombre(String nombreCargo) throws CargoException{

        if(cargoRepository.findCargoByNombreCargo(nombreCargo).isPresent()){
            throw new CargoException("El campo nombre se encuentra vacio o no existe en el sistema");
        }
        return cargoMapper.cargoModelToCargoDTO(cargoRepository.findCargoByNombreCargo(nombreCargo).get());
    }
}
