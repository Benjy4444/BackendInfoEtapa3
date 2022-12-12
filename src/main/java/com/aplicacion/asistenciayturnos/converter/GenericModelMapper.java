package com.aplicacion.asistenciayturnos.converter;

import com.aplicacion.asistenciayturnos.dto.OrganizacionDto;
import com.aplicacion.asistenciayturnos.entity.Organizacion;
import org.modelmapper.ModelMapper;

import java.util.Optional;

public class GenericModelMapper {

    private final ModelMapper mapper = new ModelMapper();

    private static GenericModelMapper instance;

    private GenericModelMapper() {

    }

    public static GenericModelMapper singleInstance() {

        if (instance==null){

            instance = new GenericModelMapper();

        }
        return instance;
    }

    public OrganizacionDto mapToOrganizacionDto(Optional<Organizacion> organizacion){
        return mapper.map(Organizacion.class,OrganizacionDto.class);
    }

}
