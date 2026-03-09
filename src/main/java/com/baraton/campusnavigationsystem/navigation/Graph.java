package com.baraton.campusnavigationsystem.navigation;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Graph {
    private Set<Node> nodes=new HashSet<>();

    public void  addNode(Node node){
        nodes.add(node);
    }
}
