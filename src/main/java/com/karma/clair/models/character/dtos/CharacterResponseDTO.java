package com.karma.clair.models.character.dtos;

import com.karma.clair.enums.Gender;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterResponseDTO {
    private UUID id;
    private String name;
    private Integer age;
    private String region;
    private Gender gender;
    private String photo;
}
