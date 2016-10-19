/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Viveka.Aggarwal
 * Source: http://www.geeksforgeeks.org/shortest-path-in-a-binary-maze/
 * Questions: Given a MxN matrix where each element can either be 0 or 1. We need to find the shortest path between a given source cell to a destination cell. The path can only be created out of a cell if its value is 1.

Expected time complexity is O(MN).

For example –

Input:
mat[ROW][COL]  = {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                  {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                  {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                  {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                  {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                  {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                  {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                  {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                  {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
Source = {0, 0};
Destination = {3, 4};

Output:
Shortest Path is 11 
 */

public class ShortestDistanceInBinaryMaze 
{
    public class Node
    {
        int x;
        int y;
        
        Node(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }
    
    public class QNode
    {
        Node n;
        int distance;
        
        QNode(Node n, int distance)
        {
            this.n = n;
            this.distance = distance;
        }
        
        QNode(int x, int y, int distance)
        {
            this.n = new Node(x, y);
            this.distance = distance;
        }
    }
    
    public int FindShortestDistance(int[][] maze, int x, int y)
    {
       Node source = new Node(0, 0);
       Node destination = new Node(x, y);
       
       return FindShortestDistance(maze, source, destination);
    }
    
    private boolean IsValid(int rows, int col, int x, int y)
    {
        return (x >= 0 && y >= 0 && x < rows && y < col);
    }
    
    public int FindShortestDistance(int[][] maze, Node src, Node des)
    {
        if(maze[src.x][src.y] == 0 || maze[des.x][des.y] == 0)
        {
            return Integer.MIN_VALUE;
        }
        
        int[] rows = {-1, 0, 0, 1 };
        int[] columns = {0, -1, 1, 0};
        
        boolean[][] isVisited = new boolean[maze.length][maze[0].length];
       // Arrays.fill(isVisited, Boolean.FALSE);
        
        Queue<QNode> q = new LinkedList<QNode>();
        q.add(new QNode(src, 0));
        isVisited[src.x][src.y] = true; 
        
        while(!q.isEmpty())
        {
            QNode cur = q.poll(); 
            
            if(cur.n.x == des.x && cur.n.y == des.y)
                return cur.distance;
            
            for(int i = 0 ; i < 4 ; i++)
            {
                int cur_row = cur.n.x + rows[i];
                int cur_col = cur.n.y + columns[i];
                
                if(IsValid(maze.length, maze[0].length, cur_row, cur_col) && !isVisited[cur_row][cur_col] && maze[cur_row][cur_col] != 0)
                {   
                    isVisited[cur_row][cur_col] = true;
                    QNode next = new QNode(cur_row, cur_col, cur.distance +1);
                    q.add(next);
                }
            }
        }
        
        // No solution was found
        return Integer.MIN_VALUE;
    }
    
    public static void main(String[] a)
    {
        int[][] maze =  {{1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                  {1, 0, 1, 0, 1, 1, 1, 0, 1, 1 },
                  {1, 1, 1, 0, 1, 1, 0, 1, 0, 1 },
                  {0, 0, 0, 0, 1, 0, 0, 0, 0, 1 },
                  {1, 1, 1, 0, 1, 1, 1, 0, 1, 0 },
                  {1, 0, 1, 1, 1, 1, 0, 1, 0, 0 },
                  {1, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
                  {1, 0, 1, 1, 1, 1, 0, 1, 1, 1 },
                  {1, 1, 0, 0, 0, 0, 1, 0, 0, 1 }};
        
        ShortestDistanceInBinaryMaze sdibm = new ShortestDistanceInBinaryMaze();
        int pathLength = sdibm.FindShortestDistance(maze, 3, 4);
        System.out.println(pathLength);
    }
}
