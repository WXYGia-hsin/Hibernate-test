package com.wang.test;

public class Husband {
    private int id;
    private String husbandname;
    private Wife wife;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHusbandname() {
        return husbandname;
    }

    public void setHusbandname(String husbandname) {
        this.husbandname = husbandname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Husband husband = (Husband) o;

        if (id != husband.id) return false;
        if (husbandname != null ? !husbandname.equals(husband.husbandname) : husband.husbandname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (husbandname != null ? husbandname.hashCode() : 0);
        return result;
    }

    public Wife getWife() {
        return wife;
    }

    public void setWife(Wife wife) {
        this.wife = wife;
    }
}
