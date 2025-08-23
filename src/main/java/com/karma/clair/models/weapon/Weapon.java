package com.karma.clair.models.weapon;

import com.karma.clair.enums.Gender;
import com.karma.clair.enums.WeaponType;
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
@Table(name = "tb_weapon")
public class Weapon implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;
    private WeaponType weaponType;
    private Integer level;

    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;

    public Weapon(UUID id, String name, WeaponType weaponType, Integer level,LocalDateTime created_at, LocalDateTime updated_at) {
        this.id = id;
        this.name = name;
        this.weaponType = weaponType;
        this.level = level;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Weapon() { }
}
