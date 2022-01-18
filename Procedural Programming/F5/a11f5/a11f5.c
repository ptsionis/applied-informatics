#include <stdio.h>
#include <math.h>
#include "genlib.h"
#include "simpio.h"

#define CTS 10
#define S 3

int main()
{
    int i, j;
    double temper[CTS][S], sum, natavg, average[CTS], devnat[CTS][S], mdeviation[CTS];

    for (i=0; i<CTS; i++)
    {
        for (j=0; j<S; j++)
        {
            printf("Temp of City %d During %d 8-hour period: ", i, j);
            temper[i][j] = GetReal();
        }
    }

    sum = 0;
    for (i=0; i<CTS; i++)
    {
        for (j=0; j<S; j++)
        {
            sum += temper[i][j];
        }
    }
    natavg = sum/(CTS*S);
    printf("%3.1f\n", natavg);

    for (i=0; i<CTS; i++)
    {
        average[i]=0;
        for (j=0; j<S; j++)
        {
            average[i] += temper[i][j];
        }
        average[i] /= S;
    }

    for (i=0; i<CTS; i++)
    {
        for (j=0; j<S; j++)
        {
            devnat[i][j] = fabs(natavg-temper[i][j]);
        }
    }
    for (i=0; i<CTS; i++)
    {
        mdeviation[i] = devnat[i][0];
        for (j=1; j<S; j++)
        {
            if (mdeviation[i]<devnat[i][j])
            {
                mdeviation[i] = devnat[i][j];
            }
        }
    }

    for (i=0; i<CTS; i++)
    {
        printf("City %d  %0.1f  %0.1f\n", i, average[i], mdeviation[i]);
    }

    return 0;
}
