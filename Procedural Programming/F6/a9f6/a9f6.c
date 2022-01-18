#include <stdio.h>

#define SALESMEN 4
#define PRODUCTS 5

void calculateSales(int S, int P, int salesTable[S][P], int price[], int sp[]);
void calculateProductSales(int S, int P, int salesTable[S][P], int prods[]);
void maxArray(int size, int table[], int *max, int *pos);
void printArray(int size, int table[]);

int main()
{
    int sales[SALESMEN][PRODUCTS] = {{10,4,5,6,7},{7,0,12,1,3},{4,19,5,0,8},{3,2,1,5,6}};
    int price[PRODUCTS] = {250,150,320,210,920};
    int salesPerson[SALESMEN];
    int productSale[PRODUCTS];
    int income, MaxSalesMan, items, MaxProduct;
    calculateSales(SALESMEN, PRODUCTS, sales, price, salesPerson);
    calculateProductSales(SALESMEN, PRODUCTS, sales, productSale);
    maxArray(SALESMEN, salesPerson, &income, &MaxSalesMan);
    maxArray(PRODUCTS, productSale, &items, &MaxProduct);
    printf("SalesMan-Sales \n");

    printArray(SALESMEN, salesPerson);
    printf("Best SalesMan was %d with %d sales\n", MaxSalesMan, income);
    printf("Product-Items \n");
    printArray(PRODUCTS, productSale);
    printf("Best Product was %d with %d items\n", MaxProduct, items);


    return 0;
}

calculateSales(int S, int P, int salesTable[S][P], int price[], int sp[])
{
    for (int i=0; i<S; i++)
    {
        sp[i] = 0;
        for (int j=0; j<P; j++)
        {
            sp[i] += salesTable[i][j]*price[j];
        }
    }
}

calculateProductSales(int S, int P, int salesTable[S][P], int prods[])
{
   for (int i=0; i<P; i++)
   {
       prods[i] = 0;
       for (int j=0; j<S; j++)
       {
           prods[i] += salesTable[j][i];
       }
   }
}

void maxArray(int size, int table[], int *max, int *pos)
{
    *max = table[0];
    *pos = 0;
    for (int i=1; i<size; i++)
    {
        if (*max < table[i])
        {
            *max = table[i];
            *pos = i;
        }
    }
}

void printArray(int size, int table[])
{
    int i;
    for (i=0; i<size; i++)
    {
        printf("    %d    %d \n", i, table[i]);
    }
}
