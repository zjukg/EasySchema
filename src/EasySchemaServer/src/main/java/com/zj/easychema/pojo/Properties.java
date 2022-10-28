package com.zj.easychema.pojo;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Properties {
    private String version ;
    private String category ;
    private String name ;
    private String description ;
    private String nameZh ;
    private String descriptionZh ;
    private String subPropertyOf ;
    private String equivalentProperty ;
    private String subproperties ;
    private String inverseOf ;
    private String domainIncludes ;
    private String rangeIncludes ;
    private String wikidataUrl ;
    private String schemaorgUrl ;
}
