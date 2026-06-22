package com.mapper;

import com.dto.SupervisoreDto;
import com.entity.Supervisore;

public class SupervisoreMapper {

    public static SupervisoreDto mapToSupervisoreDto(Supervisore supervisore)


    {
        return new SupervisoreDto(
                supervisore.getMatricola(),
                supervisore.getNomeUtente()
        );
    }


    public static Supervisore mapToSupervisore(SupervisoreDto supervisoreDto)
        {
            return new Supervisore(
                    supervisoreDto.getMatricola(),
                    supervisoreDto.getNomeUtente()
            );
        }

}
