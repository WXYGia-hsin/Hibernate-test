package com.wang.po;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Teacher {
    private int teacherId;
    private String teacherName;
    private Set<Student> students=new HashSet<Student>();

    @Id
    @Column(name = "teacher_ID")
    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    @Basic
    @Column(name = "teacher_name")
    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (teacherId != teacher.teacherId) return false;
        if (teacherName != null ? !teacherName.equals(teacher.teacherName) : teacher.teacherName != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = teacherId;
        result = 31 * result + (teacherName != null ? teacherName.hashCode() : 0);
        return result;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "course", catalog = "", schema = "project1", joinColumns = @JoinColumn(name = "teacher_ID", referencedColumnName = "teacher_ID", nullable = false), inverseJoinColumns = @JoinColumn(name = "student_ID", referencedColumnName = "student_ID", nullable = false))
    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
