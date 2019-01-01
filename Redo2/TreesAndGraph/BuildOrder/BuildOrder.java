package TreesAndGraph.BuildOrder;

// you are given a list of projects and a list of dependencies (which is a list of pairs of projects, where
// the second project is dependent on the first project). All of a project dependencies must be built before
// the project is. Find the build order that will allow the projects to be built. If there is no valid
// build order, return an error

import java.util.ArrayList;

// example
// input:
//        projects: a, b, c, d, e, f
//        dependencies: (a, d), (f, b), (b, d), (f, a), (d, c)
// output:
//         f, e, a, b, d, c
public class BuildOrder {
    // we have to create a project class
    // we have to create a graph class to connect all the projects

    Project[] findBuildOrder(String[] projects, String[][] dependencies) {
        Graph graph = buildGraph(projects, dependencies);   // build the graph with the projects and dependencies
        return orderProjects(graph.getNodes()); // find the project order with the graph
    }

    private Project[] orderProjects(ArrayList<Project> projects) {
        // an array to keep track of the order that the projects are going to be build
        Project[] order = new Project[projects.size()];

        // adding all of the projects that does not have dependencies
        // endOfList is an index to insert the next project
        int endOfList = addNonDependent(order, projects, 0);

        int toBeProcessed = 0;  // current index of the project to be processed for dependants
        while (toBeProcessed < order.length) {  // need to process all the projects
            Project current = order[toBeProcessed]; // getting a project from the order array

            // there is a circular dependency since there are no remaining projects with zero dependencies
            if (current == null) {
                return null;
            }

            // since we have already add the project to the build order
            // all of the children of this current project will have their number of dependencies decremented

            // remove the projects with dependency
            ArrayList<Project> children = current.getChildren();
            for (Project child: children) {
                child.decrementDependencies();  // decrementing the number of dependencies of the children
            }

            // add all of the children with no more dependents to the order array
            endOfList = addNonDependent(order, children, endOfList);
            toBeProcessed++;    // finished processing the current project, move on to the next one
        }

        return order;   // return the list of projects in the right build order
    }

    // offset it to keep track of the current empty index to insert a project into the order array
    private int addNonDependent(Project[] order, ArrayList<Project> projects, int offset) {
        for (Project project: projects) {
            if (project.getNumberDependencies() == 0) { // if the project does not have any dependencies
                order[offset] = project;    // add the project to the order array
                offset++;   // increment to the next empty spot inside the order array
            }
        }

        return offset;  // return the empty spot index for the next project
    }

    private Graph buildGraph(String[] projects, String[][] dependencies) {
        Graph graph = new Graph();

        // create the nodes inside the graph using project names
        for (String project: projects) {
            graph.getOrCreateNode(project);
        }

        for (String[] dependency: dependencies) {
            String first = dependency[0];
            String second = dependency[1];
            graph.addEdge(first, second);   // connect the two projects
                                            // the first project must be built first, before the second project
        }

        return graph;   // return the newly made graph.     
    }
}












