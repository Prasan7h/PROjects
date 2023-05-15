#include<stdio.h>
#include<string.h>

int main()
{
int size=0,i,j;
char s1[100];
char a,b,c;

char s2[100];
scanf("%s",s1);
printf("enter sec");
scanf("%s",s2);
printf("%s%s",s1,s2);

for(i=0;i<strlen(s1);i++)
{
    for(j=0;j<strlen(s2);j++)
    {
     if(s1[i]!=-1&&s2[j]!=-1)
     {
         if(s1[i]==s2[j])
          {
              s1[i]=-1;
              s2[j]=-1;
            size+=2;
          }

     }
    }
}
size=strlen(s1)+strlen(s2)-size;
//printf("%d",size);


char f[6]={'f','l','a','m','e','s'};
int n=5,k,s=0;
while(n)
{
   // printf("%d",n);
    k=size;

    while(k)
        {
            if(s>=6)
                {
         s=s%6;
        }
        if(f[s]!=-1)
           {
               k--;

           }

        s++;
    }
    printf(" %c ",f[s-1]);
    f[s-1]=-1;
    n--;
}
char ch;
for(i=0;i<5;i++){
    if(f[i]!=-1)
        ch=f[i];
}
switch(ch){
case 'f':
    {printf("friend");
    break;
    }

case 'l':
    {


    printf("love");
break;
}
case 'a':{
    printf("affection");
    break;}
case 'm':{
    printf("marriage");
    break;}
case 'e':{
printf("enemy");
break;
}
case 's':
    {
        printf("sister");
        break;
    }
}

}
