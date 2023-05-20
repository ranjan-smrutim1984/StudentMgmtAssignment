package com.neo.StudentProject.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class StudentMarksDTO {
    @NotNull(message="Mark1 is required")
    @Min(value =0,message="Mark1 should be atleast 0")
    @Max(value =100,message="Mark1 should be atmost 100")
    private Integer mark1;
    @NotNull(message="Mark2 is required")
    @Min(value =0,message="Mark2 should be atleast 0")
    @Max(value =100,message="Mark2 should be atmost 100")
    private Integer mark2;
    @NotNull(message="Mark3 is required")
    @Min(value =0,message="Mark3 should be atleast 0")
    @Max(value =100,message="Mark3 should be atmost 100")
    private Integer mark3;

    public StudentMarksDTO() {
    }

    public StudentMarksDTO(Integer mark1, Integer mark2, Integer mark3) {
        this.mark1 = mark1;
        this.mark2 = mark2;
        this.mark3 = mark3;
    }

    public Integer getMark1() {
        return mark1;
    }

    public void setMark1(Integer mark1) {
        this.mark1 = mark1;
    }

    public Integer getMark2() {
        return mark2;
    }

    public void setMark2(Integer mark2) {
        this.mark2 = mark2;
    }

    public Integer getMark3() {
        return mark3;
    }

    public void setMark3(Integer mark3) {
        this.mark3 = mark3;
    }
}
