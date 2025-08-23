package com.karma.clair.services;

import com.karma.clair.models.pictos.Pictos;
import com.karma.clair.models.pictos.dtos.PictosRequestDTO;
import com.karma.clair.repositories.PictosRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictosService {

    private final PictosRepository pictosRepository;

    public PictosService(PictosRepository pictosRepository) {
        this.pictosRepository = pictosRepository;
    }

    public List<Pictos> findAll() {
        return pictosRepository.findAll();
    }

    public Pictos create(PictosRequestDTO pictosRequestDTO) {
        Pictos pictos = new Pictos();
        BeanUtils.copyProperties(pictosRequestDTO, pictos);

        pictosRepository.save(pictos);

        return pictos;
    }

}
