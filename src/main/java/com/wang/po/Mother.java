package com.wang.po;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Mother {
    private int id;
    private String mothername;
    private Set<Children> children=new HashSet<Children>();

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "mothername")
    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Mother mother = (Mother) o;

        if (id != mother.id) return false;
        if (mothername != null ? !mothername.equals(mother.mothername) : mother.mothername != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mothername != null ? mothername.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "mother",cascade = CascadeType.ALL)
    public Set<Children> getChildren() {
        return children;
    }

    public void setChildren(Set<Children> children) {
        this.children = children;
    }
}
