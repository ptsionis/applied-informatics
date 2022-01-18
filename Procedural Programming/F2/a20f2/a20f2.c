#include <stdio.h>
#include "genlib.h"
#include "simpio.h"

int main()
{
    int arithmos_imeras;

    printf("Dwse enan arithmo apo to 1 eos to 7: ");
    arithmos_imeras = GetInteger();
    if (arithmos_imeras==1)
    {
        printf("The day is Monday");
    }
    else if (arithmos_imeras==2)
    {
        printf("The day is Tuesday");
    }
    else if (arithmos_imeras==3)
    {
        printf("The day is Wednesday");
    }
    else if (arithmos_imeras==4)
    {
        printf("The day is Thursday");
    }
    else if (arithmos_imeras==5)
    {
        printf("The day is Friday");
    }
    else if (arithmos_imeras==6)
    {
        printf("The day is Saturday");
    }
    else if (arithmos_imeras==7)
    {
        printf("The day is Sunday");
    }
    else
    {
        printf("ERROR");
    }

    return 0;
}
