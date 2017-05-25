package org.sft.test.model;

/**
 * 宠物
 */
public class Pet {
    /**
     * 宠物分类
     */
    private String type;

    private int age;

    private String description;

    public String getType() {
        return type;
    }

    public Pet setType(String type) {
        this.type = type;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Pet setAge(int age) {
        this.age = age;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Pet setDescription(String description) {
        this.description = description;
        return this;
    }
}
