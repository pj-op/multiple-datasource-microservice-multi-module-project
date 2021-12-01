package org.ac.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "CITY_copy")
@NoArgsConstructor
@AllArgsConstructor
public class City implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CITY_CODE")
    protected int cityCode;
    @Column(name = "CITY_NAME")
    protected String cityName;
    @Column(name = "CITY_PINCODE")
    protected int cityPincode;

}
