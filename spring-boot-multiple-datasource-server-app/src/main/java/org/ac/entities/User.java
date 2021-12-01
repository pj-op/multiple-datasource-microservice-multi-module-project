package org.ac.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(name = "user_name")
    private String userName;
    private String password;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private List<UserRole> userRole;
}
