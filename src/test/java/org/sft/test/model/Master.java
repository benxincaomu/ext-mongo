package org.sft.test.model;

import java.util.List;

/**
 * 宠物主人，测试实体
 */
public class Master {
    /**
     * 姓名
     */
    private String name;

    private String addr;
    private List<Pet> pets;

    public String getName() {
        return name;
    }

    public Master setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddr() {
        return addr;
    }

    public Master setAddr(String addr) {
        this.addr = addr;
        return this;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public Master setPets(List<Pet> pets) {
        this.pets = pets;
        return this;
    }
}
