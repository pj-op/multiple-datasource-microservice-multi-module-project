package org.ac.entities;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.io.Serializable;

@Data
@Document
public class Customer implements Serializable {

    @Id
    private String id;
    private String firstName;
    private String lastName;

}
