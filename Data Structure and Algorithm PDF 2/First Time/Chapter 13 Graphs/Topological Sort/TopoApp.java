class TopoApp
    {
    public static void main(String[] args)
        {
        Graph theGraph = new Graph();
        theGraph.addVertex(‘A’); // 0
        theGraph.addVertex(‘B’); // 1
        theGraph.addVertex(‘C’); // 2
        theGraph.addVertex(‘D’); // 3
        theGraph.addVertex(‘E’); // 4
        theGraph.addVertex(‘F’); // 5
        theGraph.addVertex(‘G’); // 6
        theGraph.addVertex(‘H’); // 7
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(0, 4); // AE
        theGraph.addEdge(1, 4); // BE
        theGraph.addEdge(2, 5); // CF
        theGraph.addEdge(3, 6); // DG
        theGraph.addEdge(4, 6); // EG
        theGraph.addEdge(5, 7); // FH
        theGraph.addEdge(6, 7); // GH
        theGraph.topo(); // do the sort
        } // end main()
    } // end class TopoApp
    ////////////////////////////////////////////////////////////////