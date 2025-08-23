package com.karma.clair.models.pictos.dtos;

import com.karma.clair.enums.PictosAttribute;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PictosResponseDTO {
    private UUID id;
    private String name;
    private String description;
    private PictosAttribute attribute;
    private Integer level;
}
