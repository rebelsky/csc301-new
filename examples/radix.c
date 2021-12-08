#include <stdio.h>
#include <stdlib.h>

/**
 * A quick and dirty implementation of radix sort.
 *
 * Sam Rebelsky
 * And the Students of CSC-301-02 2021Fa
 */

// +-----------+-----------------------------------------------------
// | Constants |
// +-----------+

#define MAX_VAL 2048
#define BITS 11

// +---------+-------------------------------------------------------
// | Helpers |
// +---------+

/**
 * Sort vals, of size n, using radix sort.
 */
void
radixSort(int vals[], int n) {
   int bitmask = 1;
   int zeros[n];        // Place to store zeros
   int ones[n];         // Place to store ones
   int z = 0;           // Number of values in the zeros array
   int o = 0;           // Number of values in the ones array

   for (int k = 0; k < BITS; k++) {
     // Clear out the arrays
     z = 0;
     o = 0;
     // For each value in vals
     for (int i = 0; i < n; i++) {
       if (vals[i] & bitmask) {
         ones[o++] = vals[i];
       }
       else {
         zeros[z++] = vals[i];
       }
     } // for
     // Shove them back in vals in the correct order
     int i = 0;
     for (int j = 0; j < z; j++) {
       vals[i++] = zeros[j];
     } 
     for (int j = 0; j < o; j++) {
       vals[i++] = ones[j];
     } // for
     // Shift to the next digits
     bitmask = bitmask << 1;
   } // for
} // radixSort

void
printInts(int vals[], int n) 
{
  printf ("{ %d", vals[0]);
  for (int i = 1; i < n; i++) {
    printf (", %d", vals[i]);
  } // for
  printf (" }\n");
} // printInts

int
main (int argc, char **argv)
{
  int vals[argc - 1];
  for (int i = 1; i < argc; i++) {
    vals[i-1] = atoi(argv[i]);
  } // for
  radixSort(vals, argc-1);
  printInts(vals, argc-1);
} // main

