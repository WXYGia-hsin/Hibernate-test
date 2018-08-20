package com.wang.po;

import javax.persistence.*;

@Entity

public class Wife {
    private int id;
    private String wifename;
    private Husband husband;
    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "wifename")
    public String getWifename() {
        return wifename;
    }

    public void setWifename(String wifename) {
        this.wifename = wifename;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wife wife = (Wife) o;

        if (id != wife.id) return false;
        if (wifename != null ? !wifename.equals(wife.wifename) : wife.wifename != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (wifename != null ? wifename.hashCode() : 0);
        return result;
    }

    @OneToOne(cascade =CascadeType.ALL)
    @JoinColumn(name = "ID", referencedColumnName = "ID", nullable = false)
    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }
}
