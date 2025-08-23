package com.karma.clair.models.pictos;

import com.karma.clair.enums.PictosAttribute;
import com.karma.clair.models.pictosBuild.PictosBuild;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@Entity
@Table(name = "tb_pictos")
public class Pictos implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private String description;
    private PictosAttribute attribute;
    private Integer level;

    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;

    @OneToMany(mappedBy = "pictos")
    private List<PictosBuild> pictosBuild;

    public Pictos(UUID id, String name, String description, PictosAttribute attribute, Integer level, LocalDateTime created_at, LocalDateTime updated_at, List<PictosBuild> pictosBuild) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.attribute = attribute;
        this.level = level;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.pictosBuild = pictosBuild;
    }

    public Pictos() {}
}
