package com.tyy.jpa.converter;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Table(name = "Dashboard")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardEntity {

    @Id
    private String id;

    @Convert(converter = JpaParentTagConverter.class)
    private List<ParentTag> parentTag;

}
