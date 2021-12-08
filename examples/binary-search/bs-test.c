#include <stdio.h>
#include "bs.h"

// +-----------+-----------------------------------------------------
// | Constants |
// +-----------+

/**
 * The largest array we'll look at.
 */
#define MAX_SIZE 33

// +---------+-------------------------------------------------------
// | Globals |
// +---------+

int tests = 0;          // The number of tests we've run
int errors = 0;         // The number of errors we've encountered.

// +---------+-------------------------------------------------------
// | Helpers |
// +---------+

void
bs_check (int val, int vals[], int size, int expected) 
{
  ++tests;
  int result = binary_search (val, vals, size);
  if (result != expected) {
    ++errors;
    fprintf (stderr, "For bs (%d, {...}, %d), expected %d, got %d.\n",
             val, size, expected, result);
  } // if
} // bs_check

// +------+----------------------------------------------------------
// | Main |
// +------+

int
main (int argc, char *argv[])
{
  int vals[MAX_SIZE];   // The array we search

  // Fill the array with 0, 2, 4, ....
  for (int i = 0; i < MAX_SIZE; i++) {
    vals[i] = 2*i;
  } // for

  // For each array size
  for (int size = 0; size <= MAX_SIZE; size++) {
    // Check for something less than the smallest value
    bs_check (-1, vals, size, -1);
    // Check for all the values that are there
    for (int i = 0; i < size; i++) 
      bs_check (2*i, vals, size, i);
    // Check between neighboring elements (and beyond the last)
    for (int i = 0; i < size; i++)
      bs_check (2*i + 1, vals, size, -1);
  } // for

  // Wrap up
  fprintf (stderr, "Passed %d of %d tests.\n", tests - errors, tests);
  return errors;
} // main
