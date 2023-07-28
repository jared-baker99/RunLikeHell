// Jared Baker (NID: ja907583)
// COP 3503, Fall 2022
// In this project we solve the RunLikeHell problem with Dynamic programing

import java.util.*;

public class RunLikeHell
{
  public static int maxGain(int [] blocks)
  {
    // Base Conditions
    // If their is no blocks then the most knowledge would be 0
    if(blocks.length == 0)
      return 0;
    // If their is only one block then that is the most knowledge that would be learned
    if(blocks.length == 1)
      return blocks[0];

    // Initilizing the array that would be needed to store the amount of knowledge
    int matrix [] = new int [3];

    // java already initilizes the arrays to 0 and the most that we need to start the loop is the
    // first number in the block
    matrix[1] = blocks[0];

    // Saves the largest combination of values in the matrix from the values we have in the block
    // matrix[i - 1] is if skipping a space doesnt add more to the total
    // matrix[i - 2] is if skipping a space is more benifical to the total.
    for (int i = 2; i <= blocks.length; i++)
      matrix[i % 3] = Math.max(matrix[(i - 1) % 3], matrix[(i - 2) % 3] + blocks[i - 1]);

    // The largest value is stored in the last block of the array
    return matrix[blocks.length % 3];
  }

  public static double difficultyRating()
  {
    return 4.0;
  }

  public static double hoursSpent()
  {
    return 18.0;
  }
}
