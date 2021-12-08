/**
 * test-rmsa.c
 * A quick test of the alternate recursive merge sort.
 */

// +---------+-------------------------------------------------------
// | Headers |
// +---------+

#include "recursive-merge-sort-alt.h"
#include "sorter.h"

// +------+----------------------------------------------------------
// | Main |
// +------+

int
main (int argc, char *argv[])
{
  int errors = test_sorter (recursive_merge_sort_alt);
  return errors;
} // main
