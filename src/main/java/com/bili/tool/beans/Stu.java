package com.bili.tool.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Setter;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Stu implements Serializable {
    public int id;
    public String name;
    public int age;
    public double height;

}
