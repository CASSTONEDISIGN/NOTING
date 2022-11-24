package com.example.backend.wait.entity;

import com.example.backend.map.entity.Store;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Entity(name = "wait")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Component
public class WaitEntity {
    @Id
    private long  id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store_id;
    private String user_phone;
    private String name;
    private String male;
    private String nop;

}
