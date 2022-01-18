#include <stdio.h>
#include <math.h>
#include "simpio.h"
#include "genlib.h"

int main()
{
    long xronia, telikos_ar;
    long orio;
    double rythmos;

    printf("Dose arxiko arithmo aytokinitwn: ");
    telikos_ar = GetLong();
    printf("Dose etisio arithmo ayksisis: ");
    rythmos = GetReal();
    printf("Dose to orio: ");
    orio = GetLong();
    xronia = 0;
    while (telikos_ar <= orio)
    {
        xronia++;
        telikos_ar = ceil(telikos_ar*(1+rythmos));
    }
    printf("%ld\n", xronia);
    printf("%ld\n", telikos_ar);

    return 0;
}
