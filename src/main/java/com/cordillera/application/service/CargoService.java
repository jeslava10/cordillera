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
    private static final String PATTERN = "^[a-zA-Z]*$";
    private static final String PATTERN_CODE = "^[0-9]*$";

    //Metodo para guardar un cargo
    public CargoDto saveCargo(CargoPostDto cargoPostDto){

        if (cargoPostDto.getNombreCargo().isBlank() || cargoPostDto.getCodigoCargo().isBlank()) {
            throw new CargoException(MensajesErrores.NOMBRE_NULL.getValue());
        } else if (!cargoPostDto.getNombreCargo().matches(PATTERN) || !cargoPostDto.getCodigoCargo().matches(PATTERN_CODE)) {
            throw new CargoException(MensajesErrores.CARACTERES_NO_VALIDOS.getValue());
        } else if (cargoPostDto.getCodigoCargo().isBlank()) {
            throw new CargoException(MensajesErrores.CODIGO_CARGO_NULL.getValue());
        } else if(cargoRepository.findCargoByNombreCargoContainsIgnoreCase(cargoPostDto.getNombreCargo()).isPresent() || cargoRepository.findCargoByCodigoCargo(cargoPostDto.getCodigoCargo()).isPresent()){
            throw new CargoException(MensajesErrores.CARGO_YA_REGISTRADO.getValue());
        }

        Cargo cargo = new Cargo();
        try {
            cargo.setNombreCargo(cargoPostDto.getNombreCargo());
            cargo.setCodigoCargo(cargoPostDto.getCodigoCargo());
            cargo.setIdCargo(null);
            cargo = cargoRepository.save(cargo);
            return cargoMapper.cargoModelToCargoDTO(cargo);
        }catch (Exception e){
            throw new CargoException(e.getMessage());
        }
    }

    //Metodo para actualizar un cargo
    public CargoDto updateCargo(CargoDto cargoDto) throws CargoException{

        if (cargoDto.getNombreCargo().isBlank() || cargoDto.getCodigoCargo().isBlank()) {
            throw new CargoException(MensajesErrores.NOMBRE_NULL.getValue());
        } else if (!cargoDto.getNombreCargo().matches(PATTERN) || !cargoDto.getCodigoCargo().matches(PATTERN_CODE)) {
            throw new CargoException(MensajesErrores.CARACTERES_NO_VALIDOS.getValue());
        } else if (cargoDto.getCodigoCargo().isBlank()) {
            throw new CargoException(MensajesErrores.CODIGO_CARGO_NULL.getValue());
        } else if(cargoRepository.findCargoByNombreCargoContainsIgnoreCase(cargoDto.getNombreCargo()).isPresent() || cargoRepository.findCargoByCodigoCargo(cargoDto.getCodigoCargo()).isPresent()){
            throw new CargoException(MensajesErrores.CARGO_ACTUALIZAR_YA_EXISTE.getValue());
        }

        try {
            Cargo cargo = new Cargo();
            cargo.setNombreCargo(cargoDto.getNombreCargo());
            cargo.setCodigoCargo(cargoDto.getCodigoCargo());
            cargo.setIdCargo(cargoDto.getIdCargo());
            cargo = cargoRepository.save(cargo);
            return cargoMapper.cargoModelToCargoDTO(cargo);
        } catch (Exception e){
            throw new CargoException(e.getMessage());
        }
    }

    //Metodo para eliminar un cargo
    public void deleteCargo(Long cargoId) throws CargoException{

        if (cargoId <= 0){
            StringBuilder sb = new StringBuilder();
            sb.append(MensajesErrores.ID_CERO.getValue())
                    .append(" ó ")
                    .append(MensajesErrores.ID_NEGATIVO.getValue());
            throw new CargoException(sb.toString());
        } else if(!cargoRepository.findById(cargoId).isPresent()){
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
            return cargosDTO;
        }catch (Exception e){
            throw new CargoException(e.getMessage());
        }
    }

    public CargoDto findByCodigo(String codigoCargo) throws CargoException{

        if (codigoCargo.isBlank()) {
            throw new CargoException(MensajesErrores.CODIGO_CARGO_NULL.getValue());
        } else if (!codigoCargo.matches(PATTERN_CODE)) {
            throw new CargoException(MensajesErrores.CARACTERES_NO_VALIDOS.getValue());
        } else if(!cargoRepository.findCargoByCodigoCargo(codigoCargo).isPresent()){
            throw new CargoException(MensajesErrores.CARGO_NO_EXISTE.getValue());
        }

        try {
            Cargo cargo = cargoRepository.findCargoByCodigoCargo(codigoCargo).get();
            return cargoMapper.cargoModelToCargoDTO(cargo);
        } catch (Exception e){
            throw new CargoException(e.getMessage());
        }
    }

    public CargoDto findByNombre(String nombreCargo) throws CargoException{

        if (nombreCargo.isBlank()) {
            throw new CargoException(MensajesErrores.NOMBRE_NULL.getValue());
        } else if (!nombreCargo.matches(PATTERN)) {
            throw new CargoException(MensajesErrores.CARACTERES_NO_VALIDOS.getValue());
        } else if(!cargoRepository.findCargoByNombreCargoContainsIgnoreCase(nombreCargo).isPresent()){
            throw new CargoException(MensajesErrores.CARGO_NO_EXISTE.getValue());
        }

        try {
            Cargo cargo = cargoRepository.findCargoByNombreCargoContainsIgnoreCase(nombreCargo).get();
            return cargoMapper.cargoModelToCargoDTO(cargo);
        } catch (Exception e){
            throw new CargoException(e.getMessage());
        }
    }

}
