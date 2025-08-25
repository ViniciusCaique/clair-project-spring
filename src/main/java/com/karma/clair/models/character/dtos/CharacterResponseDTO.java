package com.karma.clair.models.character.dtos;

import com.karma.clair.enums.Gender;
import com.karma.clair.models.build.Build;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterResponseDTO implements Serializable {
    private UUID id;
    private String name;
    private Integer age;
    private String region;
    private Gender gender;
    private String photo;
}
