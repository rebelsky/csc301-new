#include "sorter.h"
#include "insertion-sort.h"
int 
main(int argc, char *argv[])
{
  return sort_main (insertion_sort, argc, argv);
} // main
