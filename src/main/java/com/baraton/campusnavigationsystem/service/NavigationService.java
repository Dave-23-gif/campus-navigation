package com.baraton.campusnavigationsystem.service;

import com.baraton.campusnavigationsystem.model.Building;
import com.baraton.campusnavigationsystem.model.Path;
import com.baraton.campusnavigationsystem.navigation.DijkstraService;
import com.baraton.campusnavigationsystem.navigation.Graph;
import com.baraton.campusnavigationsystem.navigation.Node;
import com.baraton.campusnavigationsystem.repository.BuildingRepository;
import com.baraton.campusnavigationsystem.repository.PathRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NavigationService {
    private final BuildingRepository buildingRepository;
    private final PathRepository pathRepository;

    public Graph buildGraph(){
        List<Building> buildings = buildingRepository.findAll();
        List<Path> paths = pathRepository.findAll();

        Map<Long, Node> nodeMap = new HashMap<>();

        //create nodes
        for(Building building:buildings){
            nodeMap.put(building.getId(), new Node(building.getName()));
        }

        //connect nodes(edges)

        for(Path path:paths){
            Node start=nodeMap.get(path.getStartBuilding().getId());
            Node end=nodeMap.get(path.getEndBuilding().getId());

            start.addNeighbor(end, path.getDistance());
            end.addNeighbor(start, path.getDistance());

        }
        Graph graph = new Graph();
        nodeMap.values().forEach(node->graph.addNode(node));

        return graph;


    }
    public String findShortestPath(String startName, String endName) {

        Graph graph = buildGraph();

        Node startNode = null;
        Node endNode = null;

        for (Node node : graph.getNodes()) {
            if (node.getName().equalsIgnoreCase(startName)) {
                startNode = node;
            }
            if (node.getName().equalsIgnoreCase(endName)) {
                endNode = node;
            }
        }

        if (startNode == null || endNode == null) {
            return "Invalid buildings";
        }

        DijkstraService.calculateShortestPath(graph, startNode);

        StringBuilder path = new StringBuilder();

        Node current = endNode;

        while (current != null) {
            path.insert(0, current.getName() + " → ");
            current = current.getShortestPath();
        }

        path.append("Distance: ").append(endNode.getDistance());

        return path.toString();
    }
}
