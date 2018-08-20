package com.wang.test;

public class Children {
    private int childId;
    private String childname;
    private Mother mother;

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    public String getChildname() {
        return childname;
    }

    public void setChildname(String childname) {
        this.childname = childname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Children children = (Children) o;

        if (childId != children.childId) return false;
        if (childname != null ? !childname.equals(children.childname) : children.childname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = childId;
        result = 31 * result + (childname != null ? childname.hashCode() : 0);
        return result;
    }

    public Mother getMother() {
        return mother;
    }

    public void setMother(Mother mother) {
        this.mother = mother;
    }
}
