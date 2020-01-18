package org.exyfi.lab4.grammar;

import lombok.Data;

@Data
public class Code implements Production {

    private String code;

    public Code(String code) {
        this.code = code.substring(1, code.length() - 1);
    }
}
