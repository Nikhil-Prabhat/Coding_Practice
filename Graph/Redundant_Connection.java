class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int[] result = new int[2];

        //Declaring and initialising parent array
        int[] parent = new int[edges.length];
        for(int i=0;i<parent.length;i++)
        {
            parent[i] = i;
        }

        for(int i=0;i<edges.length;i++)
        {
            int parent1 = findParent(parent,edges[i][0]);
            int parent2 = findParent(parent,edges[i][1]);
            if(parent1 != parent2)
                unionParent(parent,parent1,parent2);
            else
            {
                result[0] = edges[i][0];
                result[1] = edges[i][1];
            }
        }

        return result;

    }

    private int findParent(int[] parentArray,int element)
    {
        return parentArray[element-1];
    }

    private void unionParent(int[] parentArray, int parent1, int parent2)
    {
        for(int i=0;i<parentArray.length;i++)
            if(parentArray[i] == parent1)
                parentArray[i] = parent2;
    }
}