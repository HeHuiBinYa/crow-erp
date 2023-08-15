package com.crow.model;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:ColumnarList
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/9 21:02
 * @Role
 */
@Data
public class ColumnarList implements Serializable {
    private List nameList;
    private List countList;

    public ColumnarList() {
        if (nameList == null){
            this.nameList = new ArrayList<>();
        }
        if (countList == null){
            this.countList = new ArrayList<>();
        }
    }
}
