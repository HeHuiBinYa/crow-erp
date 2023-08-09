package com.crow.model;

import jakarta.validation.Valid;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @PackageName:IntelliJ IDEA
 * @ClassName:Association
 * @Description:
 * @Author 青黑色的乌鸦
 * @Email xingtan1976tkt@163.com
 * @Date 2023/8/3 8:53
 * @Role
 */
@Data
public class Association implements Serializable {
    @Valid
    private Employee employee;
    private Position position;
    private Department department;

    public Association() {
        if (this.getEmployee() == null){
            this.setEmployee(new Employee());
        }
        if (this.getPosition() == null){
            this.setPosition(new Position());
        }
        if (this.getDepartment() == null){
            this.setDepartment(new Department());
        }
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
