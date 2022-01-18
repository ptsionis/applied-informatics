#include <stdio.h>
#include <math.h>
#include "genlib.h"
#include "simpio.h"

#define CTS 10
#define S 3

void ReadData(int rows, int columns, double table[rows][columns]);
double CalculateAverage(int rows, int columns, double table[rows][columns]);
void CalculateAvCity(int rows, int columns, double table[rows][columns], double average[rows]);
void CalculateMaxDeviation(int rows, int columns, double avg, double table[rows][columns], double md[rows]);
void Prin_results(int rows, double avg, double average[rows], double md[rows]);

int main()
{
    double temper[CTS][S];
    double average[CTS], mdeviation[CTS];
    double natavg;

	/*Read all Temperatures*/
	ReadData(CTS, S, temper);

	/*Calculating The Average of all Cities&Temps*/
    natavg = CalculateAverage(CTS, S, temper);

	/*Calculating Average temp on each City*/
	CalculateAvCity(CTS, S, temper, average);

	/*Calculating max Deviation*/
    CalculateMaxDeviation(CTS, S, natavg, temper, mdeviation);

    /*Printing results*/
    Print_results(CTS, natavg, average, mdeviation);


    return 0;
}

void ReadData(int rows, int columns, double table[rows][columns])
{
    int i, j;

    for (i=0; i<rows; i++)
		for (j=0; j<columns; j++)
		  	{ printf("Temp of City %d During %d 8-hour period: ",i,j);
              table[i][j] = GetReal();
              }
}

double CalculateAverage(int rows, int columns, double table[rows][columns])
{
    int i, j;
    double natavg = 0;
    for (i=0; i<rows; i++)
      for (j=0; j<columns; j+=1)
         natavg += table[i][j];

    return natavg/(rows*columns);
}

void CalculateAvCity(int rows, int columns, double table[rows][columns], double average[rows])
{
    int i, j;
    for (i=0; i<rows; i++)
    {
        average[i] = 0;
        for (j=0; j<columns; j++)
        {
            average[i] += table[i][j];
        }
        average[i] = average[i]/columns;
    }
}

void CalculateMaxDeviation(int rows, int columns, double avg, double table[rows][columns], double md[rows])
{
    int i, j;
    double devnat[rows][columns];

    for (i=0; i<rows; i++)
        for (j=0; j<columns; j++)
            devnat[i][j] = fabs(avg-table[i][j]);

    for (i=0; i<rows; i++)
    {
        md[i] = devnat[i][0];
        for(j=1; j<columns; j++)
            if (md[i]<devnat[i][j]) md[i] = devnat[i][j];
    }
}

void Print_results(int rows, double avg, double average[rows], double md[rows])
{
    int i;

    printf("%3.1f\n", avg);
    for (i=0; i<rows; i+=1)
		printf("City %d  %.1f  %.1f\n",i, average[i], md[i]);
}
