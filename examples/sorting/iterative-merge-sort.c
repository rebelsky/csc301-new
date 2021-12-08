/**
 * iterative-merge-sort.c
 * An implementation of iterative merge sort.
 */

// +---------+-------------------------------------------------------
// | Headers |
// +---------+

#include <strings.h>
#include "iterative-merge-sort.h"
#include "strutils.h"

// +-----------------+-----------------------------------------------
// | Local Utilities |
// +-----------------+

int
min (int x, int y)
{
  return x < y ? x : y;
} // min

// +--------------------+--------------------------------------------
// | Exported functions |
// +--------------------+

void
iterative_merge_sort (char *strs[], int len)
{
  // Allocate a scratch array
  char *scratch[len];

  for (int size = 1; size < len; size += size)
    {
      int sizetwo = size + size;
      for (int pos = 0; pos < len; pos += sizetwo)
        {
          if (pos + size < len)
            {
              merge (strs, pos, pos+size,  min(len, pos+sizetwo), scratch);
            }
        } // for
    } // for size

} // iterative-merge_sort

