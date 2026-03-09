package com.baraton.campusnavigationsystem.navigation;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DijkstraService {
    public static Graph calculateShortestPath(Graph graph, Node source){
        source.setDistance(0);

        Set<Node> settledNodes = new HashSet<>();
        Set<Node> unsettledNodes = new HashSet<>();

        unsettledNodes.add(source);

        while(!unsettledNodes.isEmpty()){

            Node currentNode= getLowestDistanceNode(unsettledNodes);
            unsettledNodes.remove(currentNode);

            for (Map.Entry<Node, Integer> entry : currentNode.getNeighbors().entrySet()){
                Node neighbour = entry.getKey();
                int distance=entry.getValue();

                if(!settledNodes.contains(neighbour)){
                    calculateMinimumDistance(neighbour, distance, currentNode);
                    unsettledNodes.add(neighbour);
                }
            }
            settledNodes.add(currentNode);
        }
        return graph;
    }
    private static Node getLowestDistanceNode(Set<Node> unsettledNodes){
        Node lowestDistanceNode=null;
        int  lowestDistance=Integer.MAX_VALUE;
        for(Node node : unsettledNodes){
            int nodeDistance=node.getDistance();

            if(nodeDistance<lowestDistance){
                lowestDistance=nodeDistance;
                lowestDistanceNode=node;
            }
        }
        return lowestDistanceNode;
    }
    private static void calculateMinimumDistance(Node evaluationNode, int edgeWeight, Node sourceNode){
        int sourceDistance=sourceNode.getDistance();
        if(sourceDistance +  edgeWeight < evaluationNode.getDistance()){
            evaluationNode.setDistance(sourceDistance + edgeWeight);
            evaluationNode.setShortestPath(sourceNode);
        }
    }
}
