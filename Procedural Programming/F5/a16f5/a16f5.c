#include <stdio.h>
#include <stdlib.h>
#include "simpio.h"
#include "genlib.h"

void populate(int a[50]);
void printArr(int count, int a[50]);
int checkTable(int N, int count, int a[50]);

int main()
{
    int a[50], N;
    populate(a);
    int count = 50;
    printArr(count, a);
    printf("Dose arithmo apo to 0 ews to 9: ");
    N = GetInteger();
    count = checkTable(N, count, a);
    printf("\no Arithmos %d emfanizetai %d fores.\nStis theseis:\n", N, count);
    printArr(count, a);

    return 0;
}

void populate(int a[50])
{
    for (int i=0; i<50; i++)
    {
        a[i] = rand()%10;
    }
}

void printArr(int count, int a[50])
{
    for (int i=0; i<count; i++)
    {
        printf("%d ", a[i]);
    }
    printf("\n--------------\n");
}

int checkTable(int N, int count, int a[50])
{
    int k = 0;
    int pos = 0;
    for (int i=0; i<count; i++)
    {
        if (N==a[i])
        {
            k++;
        }
    }
    for (int i=0; i<count; i++)
    {
        if (N==a[i])
        {
            a[pos]=i;
            pos++;
        }
    }

    return k;
}
