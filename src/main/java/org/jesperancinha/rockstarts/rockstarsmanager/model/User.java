package org.jesperancinha.rockstarts.rockstarsmanager.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @Column(unique = true)
    private String email;

    @Column
    private String name;

    @Column
    private String password;

    @Column
    private String role;

    @Column
    @Nullable
    private Timestamp date;

}
