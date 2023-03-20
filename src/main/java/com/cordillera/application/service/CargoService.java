package com.cordillera.application.service;

import com.cordillera.application.mapper.CargoMapper;
import com.cordillera.application.repository.jpa.CargoRepository;
import com.cordillera.application.resources.MensajesErrores;
import com.cordillera.domain.dto.CargoDto;
import com.cordillera.domain.dto.CargoPostDto;
import com.cordillera.domain.excepcion.CargoException;
import com.cordillera.domain.models.Cargo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
//@RequiredArgsConstructor
public class CargoService {

    private final CargoMapper cargoMapper;
    private final CargoRepository cargoRepository;
    private static final String PATTERN = "^[a-zA-Z]*$";
    private static final String PATTERN_CODE = "^[0-9]*$";

    public CargoService(CargoMapper cargoMapper, CargoRepository cargoRepository) {
        this.cargoMapper = cargoMapper;
        this.cargoRepository = cargoRepository;
    }

    //Metodo para guardar un cargo
    public CargoDto saveCargo(CargoPostDto cargoPostDto){

        ValidaDatos(cargoPostDto);

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

        ValidaDatos(cargoDto);

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

        validaDatoString(codigoCargo);

        try {
            Cargo cargo = cargoRepository.findCargoByCodigoCargo(codigoCargo).get();
            return cargoMapper.cargoModelToCargoDTO(cargo);
        } catch (Exception e){
            throw new CargoException(e.getMessage());
        }
    }

    public CargoDto findByNombre(String nombreCargo) throws CargoException{

        validaDatoString(nombreCargo);

        try {
            Cargo cargo = cargoRepository.findCargoByNombreCargoEqualsIgnoreCase(nombreCargo).get();
            return cargoMapper.cargoModelToCargoDTO(cargo);
        } catch (Exception e){
            throw new CargoException(e.getMessage());
        }
    }

    private void ValidaDatos(CargoPostDto cargoDto) {
        if (cargoDto.getNombreCargo().isBlank()) {
            throw new CargoException(MensajesErrores.NOMBRE_NULL.getValue());
        } else if (cargoDto.getCodigoCargo().isBlank()) {
            throw new CargoException(MensajesErrores.CODIGO_CARGO_NULL.getValue());
        } else if (!cargoDto.getNombreCargo().matches(PATTERN)) {
            throw new CargoException(MensajesErrores.CARACTERES_NO_VALIDOS_NOMBRE.getValue());
        } else if (!cargoDto.getCodigoCargo().matches(PATTERN_CODE)) {
            throw new CargoException(MensajesErrores.CARACTERES_NO_VALIDOS_CODIGO.getValue());
        } else if(cargoRepository.findCargoByNombreCargoEqualsIgnoreCase(cargoDto.getNombreCargo()).isPresent()){
            throw new CargoException(MensajesErrores.CARGO_YA_REGISTRADO.getValue());
        }
    }

    private void validaDatoString(String str) {
        if (str.isBlank()) {
            throw new CargoException(MensajesErrores.CODIGO_CARGO_NULL.getValue());
        } else if (!str.matches(PATTERN_CODE)) {
            throw new CargoException(MensajesErrores.CARACTERES_NO_VALIDOS_CODIGO.getValue());
        } else if(!cargoRepository.findCargoByCodigoCargo(str).isPresent()){
            throw new CargoException(MensajesErrores.CARGO_NO_EXISTE.getValue());
        }
    }

}
