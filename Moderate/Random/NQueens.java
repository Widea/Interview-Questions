/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NQueens;

import java.util.Scanner;

/**
 * Program to implement and find solution to n queens problem using recursion.
 * @author Viveka.Aggarwal
 */
public class NQueens {
    
    static int count = 0;
    
    private boolean IsFeasible(int[] board, int cur_pos)
    {
        for(int i = 0 ; i < cur_pos ; i++)
        {
            // check if any other column has a queen on the same row as the current column.
            if(board[i] == board[cur_pos])
                return false;
            
            // check both the diagonals
            if(board[cur_pos] - board[i] == cur_pos - i)
                return false;
            
            if(board[i] - board[cur_pos] == cur_pos - i)
                return false;
        }
        return true;
    }
    
    private void Recursive(int n)
    {
        // create a board to represent just the columns and thew values enetered in it would represent the 
        // row the queen needs to be placed in. 
        int[] board = new int[n];
        Recursive(board, 0);
    }
    
    private void Recursive(int[] board, int pos)
    {
        int len = board.length;
        
        if(pos == len)
        {
            PrintBoard(board);
            count++;
        }
        else
        {
            for(int i = 0; i < len ; i++)
            {
                board[pos] = i;
                if(IsFeasible(board, pos))
                {
                    Recursive(board, pos + 1);
                }
            }
        }
    }
    
    private void PrintBoard(int[] board)
    {
        for(int i = 0 ; i < board.length; i++)
        {
           for(int j = 0 ; j < board.length; j++)
        {
            if(board[i] == j)
            {
                System.out.print("Q ");
            }
            else
            {
                System.out.print("* ");
            }
        }
           System.out.println();
        }
        System.out.println();
    }
    
    public static void main(String[] a)
    {
        Scanner in = new Scanner(System.in);
        System.out.print("\n Enter the number of queens to be placed on the board: ");
        int numOfQueens = in.nextInt();
        NQueens queens = new NQueens();
        queens.Recursive(numOfQueens);
     
        if(count == 0)
            System.out.println("Sorry! System found no feasible solution");
        else
            System.out.println("Number of possible solutions: " +count);
    }
}
