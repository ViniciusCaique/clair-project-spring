package com.karma.clair.models.pictosBuild;

import com.karma.clair.models.build.Build;
import com.karma.clair.models.pictos.Pictos;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "tb_builds")
public class PictosBuild implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "buildId")
    private Build build;

    @ManyToOne
    @JoinColumn(name = "pictosId")
    private Pictos pictos;

    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;

    public PictosBuild(UUID id, Build build, Pictos pictos, LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.build = build;
        this.pictos = pictos;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public PictosBuild() {}
}
