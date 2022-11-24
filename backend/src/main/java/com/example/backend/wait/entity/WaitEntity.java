package com.example.backend.wait.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity(name = "wait")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class WaitEntity {
    @Id
    private long  id;
    private String phone;
    private String name;
    private String male;
    private String nop;

}
