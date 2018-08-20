package com.wang.test;

public class Wife {
    private int id;
    private String wifename;
    private Husband husband;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public Husband getHusband() {
        return husband;
    }

    public void setHusband(Husband husband) {
        this.husband = husband;
    }
}
