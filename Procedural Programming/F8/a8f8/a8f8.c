#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

typedef struct
{
    int width;
    int height;
    int depth;
    int area;
    int volume;
} box;

void get_data(int *width, int *height, int *depth);
void calc_area(int width, int height, int depth, int *area);
void calc_vol(int width, int height, int depth, int *volume);

int main()
{
    box mybox;
    get_data(&mybox.width, &mybox.height, &mybox.depth);
    calc_area(mybox.width, mybox.height, mybox.depth, &mybox.area);
    calc_vol(mybox.width, mybox.height, mybox.depth, &mybox.volume);
    printf("To emvadon tou koutiou einai %d cm2\n", mybox.area);
    printf("O ogos tou koutiou einai %d cm3", mybox.volume);

    return 0;
}

void get_data(int *width, int *height, int *depth)
{
    printf("Dose to mikos tou koutiou se cm: ");
    *width = GetInteger();
    printf("Dose to ypsos tou koutiou se cm: ");
    *height = GetInteger();
    printf("Dose to vathos tou koutiou se cm: ");
    *depth = GetInteger();
}

void calc_area(int width, int height, int depth, int *area)
{
    *area = 2*(width*depth + width*height + depth*height);
}

void calc_vol(int width, int height, int depth, int *volume)
{
    *volume = width*height*depth;
}
