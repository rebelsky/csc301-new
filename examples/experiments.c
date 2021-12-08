#include <stdio.h>

/**
 * experiments.c
 * Some of Sam's random experiments.
 */

// +---------+-------------------------------------------------------
// | Headers |
// +---------+

#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include "sorting/strutils.c"

// +-------------+---------------------------------------------------
// | Experiments |
// +-------------+

/**
 * See how ithchar works.
 */
void
check_ithchar (char *str, int amt)
{
  printf ("%s: ", str);
  for (int i = 0; i < amt; i++)
    printf ("%d:%c ", i, ithchar (str, i));
  printf ("\n");
} 

/**
 * This time, we ensure that there's some data after the string
 * terminator.
 */
void
check_ithchar_again ()
{
  char str[11];
  strcpy (str, "hello");
  strcpy (str+5, "hello");
  str[5] = 0;
  check_ithchar (str, 10);
} // check_ithchar_again

/**
 * See what we get from `rand`.
 */
void
check_rand ()
{
  for (int i = 0; i < 5; i++)
    {
      printf ("rand() = %d\n", rand());
    } // for i
} // check_rand

/**
 * Check mod with negative numbers.
 */
void
negmod ()
{
  printf ("-2 %% 3: %d\n", -2 % 3);
  printf ("-5 %% 3: %d\n", -5 % 3);
} // negmod

// +------+----------------------------------------------------------
// | Main |
// +------+

int
main (int argc, char *argv[])
{
  // A bad way to seed our random number generator
  srand (time (0));

  // Our experiments
  // negmod ();
  // check_rand ();
  // check_ithchar ("hello", 10);
  check_ithchar_again ();

  // And we're done
  return 0;
} // main
