#include <stdio.h>

int main(void)
{
    char str[200];
    int len,i,start,end,j;
    printf("\nEnter any String  :");
    scanf("%[^n]s",str);
	
	//printf("%s",str);
	for(i=0;str[i];i++);
	len=i;
	
    while(i>=0)
    {
        if(str[i]==' ')
        {
            start=end=i;
            while(i>=0&&str[i]==' ')
            i--;
            start=i+1;
            for(j=start;j<=end;j++)
            printf("%c",str[j]);
        }
        else
        {
            start=end=i;
            while(i>=0&&str[i]!=' ')
            i--;
            start=i+1;
            for(j=start;j<=end;j++)
            printf("%c",str[j]); 
        }
    }

	return 0;
}

