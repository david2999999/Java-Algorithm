class Graph
    {
    private final int MAX_VERTS = 20;
    private Vertex vertexList[]; // list of vertices
    private int adjMat[][]; // adjacency matrix
    private int nVerts; // current number of vertices
    private StackX theStack;
    // -----------------------------------------------------------
    public Graph() // constructor
        {
        vertexList = new Vertex[MAX_VERTS];
        // adjacency matrix
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for(int j=0; j<MAX_VERTS; j++) // set adjacency
            for(int k=0; k<MAX_VERTS; k++) // matrix to 0
                adjMat[j][k] = 0;
                
        theStack = new StackX();
        } // end constructor
    // -----------------------------------------------------------
    public void addVertex(char lab)
        {
        vertexList[nVerts++] = new Vertex(lab);
        }
    // -----------------------------------------------------------
    public void addEdge(int start, int end)
        {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
        }
    // ------------------------------------------------------------
    public void displayVertex(int v)
        {
        System.out.print(vertexList[v].label);
        }
    // ------------------------------------------------------------
    public void dfs() // depth-first search
        { // begin at vertex 0
        vertexList[0].wasVisited = true; // mark it
        displayVertex(0); // display it
        theStack.push(0); // push it
        while( !theStack.isEmpty() ) // until stack empty,
            {
            // get an unvisited vertex adjacent to stack top
            int v = getAdjUnvisitedVertex( theStack.peek() );
            if(v == -1) // if no such vertex,
                theStack.pop();
            else // if it exists,
                {
                vertexList[v].wasVisited = true; // mark it
                displayVertex(v); // display it
                theStack.push(v); // push it
                }
            } // end while
        // stack is empty, so we’re done
        for(int j=0; j<nVerts; j++) // reset flags
            vertexList[j].wasVisited = false;
        } // end dfs
    // ------------------------------------------------------------
    // returns an unvisited vertex adj to v
    public int getAdjUnvisitedVertex(int v)
        {
        for(int j=0; j<nVerts; j++)
            if(adjMat[v][j]==1 && vertexList[j].wasVisited==false)
                return j;
                
        return -1;
        } // end getAdjUnvisitedVertex()
    // ------------------------------------------------------------
    } // end class Graph
    ////////////////////////////////////////////////////////////////