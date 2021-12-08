/**
 * recursive-merge-sort-alt.c
 * An implementation of recursive merge sort.
 */

// +---------+-------------------------------------------------------
// | Headers |
// +---------+

#include <strings.h>
#include "recursive-merge-sort-alt.h"
#include "insertion-sort.h"
#include "strutils.h"

// +-----------------+-----------------------------------------------
// | Local Utilities |
// +-----------------+

void
rmsa_kernel (char *strings[], int len, char *scratch[])
{
  // Base case: Zero or one elements are already sorted.
  if (len < 2)
    {
      return;
    }

  // Special case: Fewer than some number of elements
  else if (len < 33)
    {
      insertion_sort (strings, len);
    } // else

  else
    {
      // Recursive case: Split into parts, sort the parts, merge
#ifdef OLD
      int halfsize = len/2;
      rmsa_kernel (strings, halfsize, scratch);
      rmsa_kernel (strings+halfsize, len-halfsize, scratch);
      merge (strings, 0, halfsize, len, scratch);
#else
      int quartersize = len/4;
      int twoquarters = 2 * quartersize;
      int threequarters = 3 * quartersize;
      rmsa_kernel (strings, quartersize, scratch);
      rmsa_kernel (strings+quartersize, quartersize, scratch);
      rmsa_kernel (strings+twoquarters, quartersize, scratch);
      rmsa_kernel (strings+threequarters, len-threequarters, scratch);
      // merges
      merge (strings, 0, quartersize, twoquarters, scratch);
      merge (strings, twoquarters, threequarters, len, scratch);
      merge (strings, 0, twoquarters, len, scratch);
#endif // OLD
    } // else
} // kernel

// +--------------------+--------------------------------------------
// | Exported Functions |
// +--------------------+

void
recursive_merge_sort_alt (char *strings[], int len)
{
  // Allocate a scratch array
  char *scratch[len];

  // Use the kernel
  rmsa_kernel (strings, len, scratch);
} // recursive-merge_sort_alt

