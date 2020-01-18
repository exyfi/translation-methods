package org.exyfi.lab4.grammar;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
@RequiredArgsConstructor
public class NTerm implements Production {

    private String name;
    private List<String> parameters;

    public NTerm(String name) {
        this.name = name;
        parameters = new ArrayList<>();
    }

    public void addParameter(String parameter) {
        parameters.add(parameter);
    }

    public String getName() {
        return name;
    }

    public List<String> getParameters() {
        return parameters;
    }
}
