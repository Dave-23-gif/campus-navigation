package com.baraton.campusnavigationsystem.navigation;

import lombok.*;

import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Node {
    public String name;

    private Map<Node, Integer> neighbours=new HashMap<>();

    private int distance=Integer.MAX_VALUE;

    private Node shortestPath;

    public Map<Node,Integer> getNeighbors() {
        return neighbours;
    }
}
