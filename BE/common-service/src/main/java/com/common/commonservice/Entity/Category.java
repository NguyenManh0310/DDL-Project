package com.common.commonservice.Entity;

import com.common.commonservice.DTO.Category.CategoryCUDto;
import com.example.common.BaseEntity.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "CATEGORY")
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "category_seq_gen")
    @SequenceGenerator(name = "category_seq_gen", sequenceName = "COMMON.CATEGORY_SEQ", allocationSize = 1)
    @Column(name = "CATEGORY_ID")
    private Long categoryId;

    @Column(name = "CATEGORY_CODE")
    @Size(max = 100)
    private String categoryCode;

    @Column(name = "CATEGORY_NAME")
    @Size(max = 500)
    private String categoryName;

    @Column(name = "STATUS")
    private Long status;

    public Category(CategoryCUDto categoryCUDto){
        if(categoryCUDto!=null){
            this.categoryName=categoryCUDto.getCategoryName().trim().replaceAll("\\s+", " ");
            this.categoryCode=categoryCUDto.getCategoryCode().trim().replaceAll("\\s+", " ");
        }

    }
}
