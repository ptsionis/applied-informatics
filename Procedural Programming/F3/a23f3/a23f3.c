#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main()
{
    int i, arithmos;

    printf("Dose arithmo: ");
    arithmos = GetInteger();
    if ((arithmos%2) == 0)
    {
        for (int i=0; i<=arithmos; i+=2)
        {
            printf("%d ",i);
        }
    }
    else
    {
        for (int i=1; i<=arithmos; i+=2)
        {
            printf("%d ",i);
        }
    }

    return 0;
}
