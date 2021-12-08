/**
 * test-ims.c
 * A quick test of iterative merge sort.
 */

// +---------+-------------------------------------------------------
// | Headers |
// +---------+

#include "iterative-merge-sort.h"
#include "sorter.h"

// +------+----------------------------------------------------------
// | Main |
// +------+

int
main (int argc, char *argv[])
{
  int errors = test_sorter (iterative_merge_sort);
  return errors;
} // main
