package com.client.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Actor {

    private int actorId;
    private String firstName;
    private String lastName;
    private Date lastUpdate;


}
