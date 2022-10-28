package com.zj.easychema.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Type {
    private String SchemaorgV13 ;
    private String category ;
    private String name ;
    private String description ;
    private String nameZh ;
    private String descriptionZhJiaoYan ;
    private String properties ;
    private String equivalentClass ;
    private String subTypeOf ;
    private String subTypes ;
    private String wikidataUrl ;
    private String schemaorgUrl ;
}
