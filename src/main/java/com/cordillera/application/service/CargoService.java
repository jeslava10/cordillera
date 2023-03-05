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

        if(cargoRepository.findCargoByNombreCargo(cargoPostDto.getNombreCargo()).isPresent() && cargoPostDto.getNombreCargo().equalsIgnoreCase(cargoRepository.findCargoByNombreCargo(cargoPostDto.getNombreCargo()).get().getNombreCargo())){
            throw new CargoException(MensajesErrores.CARGO_YA_REGISTRADO.getValue());
        } else if (cargoPostDto.getNombreCargo() == null) {
            throw new CargoException(MensajesErrores.NOMBRE_NULL.getValue());
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

        if(cargoRepository.findCargoByNombreCargo(cargoDto.getNombreCargo()).isPresent() && cargoDto.getNombreCargo().equalsIgnoreCase(cargoRepository.findCargoByNombreCargo(cargoDto.getNombreCargo()).get().getNombreCargo())){
            throw new CargoException(MensajesErrores.CARGO_ACTUALIZAR_YA_EXISTE.getValue());
        }else if (cargoDto.getNombreCargo() == null) {
            throw new CargoException(MensajesErrores.NOMBRE_NULL.getValue());
        }

        Cargo cargo = new Cargo();
        try {
            cargo.setNombreCargo(cargoDto.getNombreCargo());
            cargo.setIdCargo(cargoDto.getIdCargo());
            cargo = cargoRepository.save(cargo);
        } catch (Exception e){
            throw new CargoException(e.getMessage());
        }
        return cargoMapper.cargoModelToCargoDTO(cargo);
    }

    //Metodo para eliminar un cargo
    public void deleteCargo(Long cargoId) throws CargoException{

        if(!cargoRepository.findById(cargoId).isPresent()){
            throw new CargoException(MensajesErrores.CARGO_NO_EXISTE.getValue());
        } else if (cargoId <= 0){
            StringBuilder sb = new StringBuilder();
            sb.append(MensajesErrores.ID_CERO.getValue())
                    .append(" ó ")
                    .append(MensajesErrores.ID_NEGATIVO.getValue());
            throw new CargoException(sb.toString());
        }

        try {
            cargoRepository.deleteById(cargoId);
        } catch (Exception e){
            throw new CargoException(e.getMessage());
        }
    }

    //Metodo para listar un cargo
    public List<CargoDto> listCargo() throws CargoException{
        List<Cargo> listaCargos = cargoRepository.findAll();

        if(listaCargos.isEmpty()){
            throw new CargoException(MensajesErrores.CARGOS_LISTA_VACIA.getValue());
        }

        List<CargoDto> cargosDTO = new ArrayList<>();
        try {
            for(Cargo lCargo : listaCargos){
                cargosDTO.add(cargoMapper.cargoModelToCargoDTO(lCargo));
            }
        }catch (Exception e){
            throw new CargoException(e.getMessage());
        }
        return cargosDTO;
    }

    public CargoDto findById(Long cargoId) throws CargoException{

        if(!cargoRepository.findById(cargoId).isPresent()){
            throw new CargoException(MensajesErrores.CARGO_NO_EXISTE.getValue());
        }else if (cargoId <= 0){
            StringBuilder sb = new StringBuilder();
            sb.append(MensajesErrores.ID_CERO.getValue())
                    .append(" ó ")
                    .append(MensajesErrores.ID_NEGATIVO.getValue());
            throw new CargoException(sb.toString());
        }

        Cargo cargo = new Cargo();
        try {
            cargo = cargoRepository.findById(cargoId).get();
        } catch (Exception e){
            throw new CargoException(e.getMessage());
        }
        return cargoMapper.cargoModelToCargoDTO(cargo);
    }

    public CargoDto findByNombre(String nombreCargo) throws CargoException{

        if(!cargoRepository.findCargoByNombreCargo(nombreCargo).isPresent() && nombreCargo.equalsIgnoreCase(cargoRepository.findCargoByNombreCargo(nombreCargo).get().getNombreCargo())){
            throw new CargoException(MensajesErrores.CARGO_NO_EXISTE.getValue());
        }

        Cargo cargo = new Cargo();
        try {
            cargo = cargoRepository.findCargoByNombreCargo(nombreCargo).get();
        } catch (Exception e){
            throw new CargoException(e.getMessage());
        }
        return cargoMapper.cargoModelToCargoDTO(cargo);
    }
}
