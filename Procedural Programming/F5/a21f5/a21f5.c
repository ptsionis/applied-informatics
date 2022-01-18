#include <stdio.h>
#include <math.h>
#include "simpio.h"
#include "genlib.h"

#define N 5

int main()
{
    double pin[N], rang[N-1];

    for (int i=0; i<N; i++)
    {
        printf("Enter number (%d):", i);
        pin[i] = GetReal();
    }

    for (int i=0; i<N-1; i++)
    {
        rang[i] = fabs(pin[i]-pin[i+1]);
    }

    for (int i=0; i<N; i++)
    {
        printf("%.2f ", pin[i]);
    }
    printf("\n");

    for (int i=0; i<N-1; i++)
    {
        printf("%.2f ", rang[i]);
    }

    return 0;
}
