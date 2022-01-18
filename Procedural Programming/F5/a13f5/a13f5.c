#include <stdio.h>
#include "simpio.h"
#include "genlib.h"

void populate_data(int R, int C, int A[R][C]);
void print_arrray(int R, int C, int A[R][C]);
void change_array(int R, int C, int A[R][C]);

int main()
{
    int R, C, A[10][10];

    printf("Dwse ton arithmo twn grammwn: ");
    R = GetInteger();
    printf("Dwse ton arithmo twn sthlwn: ");
    C = GetInteger();
    populate_data(R, C, A);
    printf("ARXIKOS PINAKAS");
    print_array(R, C, A);
    change_array(R, C, A);
    printf("\nALLAGMENOS PINAKAS");
    print_array(R, C, A);

    return 0;
}

void populate_data(int R, int C, int A[R][C])
{
    for (int i=0; i<R; i++)
    {
        for (int j=0; j<C; j++)
        {
            A[i][j] = rand()%100;
        }
    }
}

void print_array(int R, int C, int A[R][C])
{
    for (int i=0; i<R; i++)
    {
        printf("\n");
        for (int j=0; j<C; j++)
        {
            printf("%d ", A[i][j]);
        }
    }
}

void change_array(int R, int C, int A[R][C])
{
    int max, maxpos;
    for (int i=0; i<R; i++)
    {
        max = A[i][0];
        maxpos = 0;
        for (int j=1; j<C; j++)
        {
            if (max<=A[i][j])
            {
                max = A[i][j];
                maxpos = j;
            }
        }
        for (int j=maxpos-1; j>=0; j--)
        {
            A[i][j] = max;
        }
    }
}
