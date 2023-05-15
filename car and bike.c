#include<stdio.h>
#include<math.h>
int main(){
int n,ty,t,f;
scanf("%d %d",&ty,&n);
int a=ty/4,b=0;
//printf("%d%d",ty,n);
while(a+b!=n ) //&&((a*4)+(b*2)==ty))
{
    //printf("%d %d",a,b);
a--;
b+=2;

}
printf("%d,%d",a,b);





}
