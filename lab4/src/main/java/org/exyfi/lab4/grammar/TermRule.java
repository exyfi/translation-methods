package org.exyfi.lab4.grammar;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TermRule {

    private boolean isRegex;
    private String name;
    private String value;

}
