#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

int f(int x);
int g(int x, int y);

int main()
{
    int x,y;

    printf("Enter x: ");
    x = GetInteger();
    printf("Enter y: ");
    y = GetInteger();
    printf("f(x) = f(%d) = %d", x, f(x));
    printf("\ng(x,y) = g(%d,%d) = %d", x, y, g(x,y));
    printf("\nf(g(x,y)) = f(g(%d,%d)) = %d", x, y, f(g(x,y)));
}

int f(int x)
{
    if (x>0)
    {
        return (x+2);
    }
    else
    {
        return (-3*x+7);
    }
}

int g(int x, int y)
{
    if ((x>0) && (y>0))
    {
        return (x-y);
    }
    else
    {
        return (7*x-5);
    }
}
