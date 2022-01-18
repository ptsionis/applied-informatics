#include <stdio.h>
#include <math.h>
#include "simpio.h"
#include "genlib.h"

#define AUTOKINITA 80000
#define RYTHMOS 0.07
#define ORIO 160000

int main()
{
    long xronia, telikos_ar;

    xronia = 0;
    telikos_ar = AUTOKINITA;
    while (telikos_ar < ORIO)
    {
        xronia++;
        telikos_ar = ceil(telikos_ar*(1+RYTHMOS));
    }
    printf("%ld\n", xronia);
    printf("%ld\n", telikos_ar);
}
