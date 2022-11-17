package com.tyy.jpa.converter;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ParentTag {
    private String level;
    private String tagCode;
}
