package com.karma.clair.repositories;

import com.karma.clair.models.pictosBuild.PictosBuild;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PictosBuildRepository extends JpaRepository<PictosBuild, UUID> {
}
