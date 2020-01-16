package org.exyfi.simpleparser;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@Getter
public class Tree {
    String node;
    List<Tree> children;

    public Tree(String node) {
        this.node = node;
    }

    public Tree(String node, Tree... children) {
        this.node = node;
        this.children = Arrays.asList(children);
    }

    public void visualize(int indent) {
        String whiteSpaces = "__".repeat(Math.max(0, (indent) / 3));
        String edge = "|-";

        if (children != null) {
            for (Tree ch : children) {
                System.out.print(whiteSpaces);
                System.out.print(edge);
                if (ch.node.equals("ε")) {
                    System.out.println("END OF RULE : " + ch.node);
                } else if (ch.children == null) {
                    System.out.println("TERMINAL " + ch.node);
                } else {
                    System.out.println(ch.node);
                }
                ch.visualize(indent + 3);
            }
        }
    }
}