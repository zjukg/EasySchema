package com.zj.easychema.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
public class CellRes implements Serializable {
    private String cellName;
    private List<String> typeList;
    private List<String> propertiesList;

    public String getCellName() {
        return cellName;
    }

    public void setCellName(String cellName) {
        this.cellName = cellName;
    }

    public List<String> getTypeList() {
        return typeList;
    }

    public void setTypeList(List<String> typeList) {
        this.typeList = typeList;
    }

    public List<String> getPropertiesList() {
        return propertiesList;
    }

    public void setPropertiesList(List<String> propertiesList) {
        this.propertiesList = propertiesList;
    }
}
