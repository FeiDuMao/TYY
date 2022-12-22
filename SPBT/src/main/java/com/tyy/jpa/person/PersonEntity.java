package com.tyy.jpa.person;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@Entity
@Table(name = "person")
@AllArgsConstructor
@NoArgsConstructor
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String name;
    Integer age;
    String phoneNum;
    String address;
    @Column(insertable = false)
    LocalDateTime createTime;
    @Column(insertable = false,updatable = false)
    LocalDateTime updateTime;

}
