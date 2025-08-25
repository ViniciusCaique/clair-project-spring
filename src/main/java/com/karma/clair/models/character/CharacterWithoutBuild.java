package com.karma.clair.models.character;

import com.karma.clair.enums.Gender;
import com.karma.clair.models.build.Build;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CharacterWithoutBuild implements Serializable {
    private UUID id;
    private String name;
    private Integer age;
    private String region;
    private Gender gender;
    private String photo;

}
