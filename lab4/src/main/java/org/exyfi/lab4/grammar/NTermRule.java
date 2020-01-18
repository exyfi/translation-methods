package org.exyfi.lab4.grammar;

import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
public class NTermRule {

    @Getter
    private String name;
    private String type;
    @Getter
    private List<Argument> argList;
    @Getter
    private List<Argument> retList;
    @Getter
    private List<List<Production>> rules;

    public NTermRule(String name, List<Argument> argList, List<Argument> retList) {
        this.name = name;
        this.type = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        this.argList = argList;
        this.retList = retList;
        rules = new ArrayList<>();
    }

    public void addRule(List<Production> rule) {
        rules.add(rule);
    }

    public String getRetType() {
        if (retList == null) return "void";
        return type;
    }
}
