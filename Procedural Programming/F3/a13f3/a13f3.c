#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int main()
{
    int N;
    float sum;

    printf("Dose orio: ");
    N = GetInteger();
    sum = 0;
    for (int i=1; i<=N; i++)
    {
        sum += 1.0/i;
    }
    printf("To athroisma einai: %0.2f", sum);

    return 0;
}
