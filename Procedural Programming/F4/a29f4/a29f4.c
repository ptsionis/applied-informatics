#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int phi(int i);
int gcd(int a, int b);

int main()
{
    int x;

    printf("Enter x: ");
    x = GetInteger();
    for (int i=1; i<=x; i++)
    {
        printf("phi(%d) = %d\n", i, phi(i));
    }
}

int phi(int i)
{
    int count;
    count = 0;
    for (int j=1; j<=i; j++)
    {
        if (gcd(j,i)==1)
        {
            count++;
        }
    }

    return count;
}

int gcd(int a, int b)
{
    if (b==0)
    {
        return a;
    }
    else
    {
        return gcd(b,(a%b));
    }
}
