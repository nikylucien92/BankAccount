package com.serviceImpl;

import com.dto.SupervisoreDto;
import com.entity.Supervisore;
import com.mapper.SupervisoreMapper;
import com.repository.RepositorySupervisore;
import com.service.ServiceSupervisore;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceSupervisoreImpl  implements ServiceSupervisore {

   private final  RepositorySupervisore repoSupervisore;

    @Autowired
     public ServiceSupervisoreImpl(RepositorySupervisore repoSupervisore)
    {
         this.repoSupervisore=repoSupervisore;

     }


    @Override
    @Transactional
    public SupervisoreDto creaSupervisore(SupervisoreDto supervisoreDto) {

        Supervisore supervisore=SupervisoreMapper.mapToSupervisore(supervisoreDto);
           Supervisore supervisoreSalvato=repoSupervisore.save(supervisore);
           return SupervisoreMapper.mapToSupervisoreDto(supervisoreSalvato);
    }



}
