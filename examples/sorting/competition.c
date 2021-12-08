/**
 * competition.c
 * A friendly competition between sorting algorithms.
 *
 * Usage:
 *   competition [size [rounds [start]]]

 */

// +---------+-------------------------------------------------------
// | Headers |
// +---------+

#include "sorter.h"
#include "insertion-sort.h"
#include "recursive-merge-sort.h"
#include "iterative-merge-sort.h"
#include "recursive-merge-sort-alt.h"
#include "simple-bucket-sort.h"
#include <stdlib.h>
#include <stdio.h>
#include <strings.h>
#include <sys/time.h>

// +-----------+-----------------------------------------------------
// | Constants |
// +-----------+

/**
 * The default number of rounds of sorting.
 */
#define DEFAULT_ROUNDS 10

/**
 * The default size for one round.
 */
#define DEFAULT_SIZE 2000

// +-------+---------------------------------------------------------
// | Types |
// +-------+

struct sorting_algorithm 
  {
    char *name;
    string_sorter sort;
  };

// +---------+-------------------------------------------------------
// | Helpers |
// +---------+

/**
 * Build a random string.  The client is responsible for freeing
 * this string.
 */
char *
random_string ()
{
  char *str = malloc(8 * sizeof(char));
  for (int i = 0; i < 7; i++)
    {
      str[i] = 'a' + (rand () % 26);
    } // for
  str[7] = 0;
  return str;
} // random_string ()

// +------+----------------------------------------------------------
// | Main |
// +------+

int
main (int argc, char *argv[])
{
  // Prepare our list of sorting algorithms
  struct sorting_algorithm sorts[] =
    {
      { "insertion sort", insertion_sort },
      { "iterative merge sort", iterative_merge_sort },
      { "recursive merge sort", recursive_merge_sort },
      { "recursive merge sort alt", recursive_merge_sort_alt },
      { "simple bucket sort", simple_bucket_sort },
    };

  // Determine the number of competitor
  int competitors = sizeof (sorts) / sizeof (struct sorting_algorithm);

  // Determine the size of the array
  int size = (argc > 1 ? atoi (argv[1]) : DEFAULT_SIZE);

  // Determine the number of rounds
  int rounds = (argc > 2 ? atoi (argv[2]) : DEFAULT_ROUNDS);

  // Determine the starting round
  int start = (argc > 3 ? atoi (argv[3]) : 0);

  // Set up our original array
  char *original[size];
  char *strings[size];

  // Run all of the rounds 
  printf ("round,size");
  for (int i = 0; i < competitors; i++)
    {
      printf (",\"%s\"", sorts[i].name);
    } // for
  printf ("\n");

  for (int round = 0; round < rounds; round++)
    {
      // Fill the array
      for (int i = 0; i < size; i++)
        {
          original[i] = random_string();
        } // for

      // Run all the sorts
      printf ("r%03d,%d", round+start, size);
      for (int i = 0; i < competitors; i++)
        {
          bcopy (original, strings, size * sizeof (char *));
          struct timeval start;
          struct timeval finish;
          gettimeofday (&start, NULL);
          (sorts[i].sort) (strings, size);
          gettimeofday (&finish, NULL);
          long elapsed = (finish.tv_sec - start.tv_sec) * 1000000 
                       + (finish.tv_usec - start.tv_usec);
          printf (",%ld", elapsed);
        } // for
      printf ("\n");

      // Clean up after ourselves
      for (int i = 0; i < size; i++)
        {
          free (original[i]);
        } // for
    } // for round
  // And we're done.
  return 0;
} // main
