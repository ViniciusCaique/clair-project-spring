package com.karma.clair.models.build;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.karma.clair.models.character.CharacterClair;
import com.karma.clair.models.pictosBuild.PictosBuild;
import com.karma.clair.models.weapon.Weapon;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;


@Entity
@Data
@Table(name = "tb_builds")
public class Build implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String name;
    private String description;
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "build")
    @Size(max = 3)
    private List<PictosBuild> pictosBuild;

    @ManyToOne
    @JoinColumn(name = "characterId", nullable = false)
    private CharacterClair character;

    @ManyToOne
    @JoinColumn(name = "weaponId", nullable = false)
    private Weapon weapon;

    public Build(UUID id, String name, String description, LocalDateTime created_at, LocalDateTime updated_at, CharacterClair character, Weapon weapon) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.character = character;
        this.weapon = weapon;
//        this.pictosBuild = pictosBuild;
    }

//    List<PictosBuild> pictosBuild

    public Build() {}
}
