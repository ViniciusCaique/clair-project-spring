package com.karma.clair.models.character;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.karma.clair.enums.Gender;
import com.karma.clair.models.build.Build;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Entity
@Data
@Table(name = "tb_characters")
public class CharacterClair implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private Integer age;
    private String region;
    private Gender gender;
    private String photo;

    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "character")
    private List<Build> builds;

    public CharacterClair (UUID id, String name, Integer age, String region, Gender gender, String photo, LocalDateTime created_at, LocalDateTime updated_at, List<Build> builds) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.region = region;
        this.gender = gender;
        this.photo = photo;
        this.builds = builds;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public CharacterClair () {}
}
