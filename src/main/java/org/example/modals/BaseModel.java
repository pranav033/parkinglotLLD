package org.example.modals;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BaseModel {

    public int id;
    public Date createdAt;
    public Date updatedAt;
}
