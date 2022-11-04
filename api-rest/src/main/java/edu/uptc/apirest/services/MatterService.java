package edu.uptc.apirest.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uptc.apirest.entities.Matter;
import edu.uptc.apirest.repositories.MatterRepository;


@Service
public class MatterService {

    @Autowired
    private MatterRepository matRepository;



    public MatterService(MatterRepository matRepository) {
        this.matRepository = matRepository;
    }

    public List<Matter> getMatters(){

        return matRepository.findAll();
    }

    public Matter save( Matter matter){

      return matRepository.save(matter);
    }

    public Matter findById(String code){
        
        Optional<Matter> optMat = matRepository.findById(code);

        return optMat.isPresent() ? optMat.get() : null;
    }

    public Matter update(Matter matter){

        if(matter.getCode()!=null){
            Optional<Matter> e = matRepository.findById(matter.getCode());
            if(e.isEmpty()){
                if(matter.getDescription()!=null){
                    e.get().setDescription(matter.getDescription());
                }
                if(matter.getCedits()!=null){
                    e.get().setCedits(matter.getCedits());
                }
                matRepository.save(e.get());
                return e.get();
            }else{
                return matter;
            }
        }else{
            return matter;
        }
    }

   /* public Act update(Act act){

        if( findById( act.getId()) !=  null ){
            return actRepository.save( act );
        }

        return null;
    } */

    public Matter delete(String code) {
        Matter matter = findById( code );
        if( matter != null){
            matRepository.delete( matter );
        }

        return matter;
    }

    
}
