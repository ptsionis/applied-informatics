#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

#define N 5

void readData(int pin[N][4]);
void FindMean(int i, float *avgmen, float *avgwom, int pin[N][4]);

int main()
{
    int pin[N][4];
    float avweimen, avweiwom, avheimen, avheiwom, avagemen, avagewom;
    readData(pin);
    FindMean(1, &avweimen, &avweiwom, pin);
    FindMean(2, &avheimen, &avheiwom, pin);
    FindMean(3, &avagemen, &avagewom, pin);
    printf("Mesos oros barous andrwn: %.1f\n", avweimen);
    printf("Mesos oros barous gynaikwn: %.1f\n\n", avweiwom);
    printf("Mesos oros ypsous andrwn: %.1f\n", avheimen);
    printf("Mesos oros ypsous gynaikwn: %.1f\n\n", avheiwom);
    printf("Mesos oros hlikias andrwn: %.1f\n", avagemen);
    printf("Mesos oros hlikias gynaikwn: %.1f", avagewom);

    return 0;
}

void readData(int pin[N][4])
{
    for (int i=0; i<N; i++)
    {
        printf("Dwse fylo: ");
        pin[i][0] = GetInteger();
        printf("Dwse baros: ");
        pin[i][1] = GetInteger();
        printf("Dwse ypsos: ");
        pin[i][2] = GetInteger();
        printf("Dwse ilikia: ");
        pin[i][3] = GetInteger();
        printf("-----\n");
    }
}

void FindMean(int i, float *avgmen, float *avgwom, int pin[N][4])
{
    int men = 0;
    int wom = 0;
    *avgmen = 0.0;
    *avgwom = 0.0;
    for (int k=0; k<N; k++)
    {
        if (pin[k][0]==0)
        {
            *avgmen += pin[k][i];
            men++;
        }
        else
        {
            *avgwom += pin[k][i];
            wom++;
        }
    }
    *avgmen /= men;
    *avgwom /= wom;
}
