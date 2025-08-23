package com.karma.clair.services;


import com.karma.clair.models.pictosBuild.PictosBuild;
import com.karma.clair.repositories.PictosBuildRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class PictosBuildService {

    private final PictosBuildRepository pictosBuildRepository;

    public PictosBuildService(PictosBuildRepository pictosBuildRepository) {
        this.pictosBuildRepository = pictosBuildRepository;
    }

    public PictosBuild findById(UUID id) {
        return pictosBuildRepository.findById(id).orElse(null);
    }

    public PictosBuild create(PictosBuild pictosBuild) {
        return pictosBuildRepository.save(pictosBuild);
    }
}
