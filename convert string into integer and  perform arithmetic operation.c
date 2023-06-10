
#include<stdio.h>
#include<string.h>
void checkno(char*);
void clear();
char arr1[10];
int ind=0;
char strarr[100];
int intarr[100];
char symb[100];


int main(){
char str[100];
scanf("%s",str);
//char arr1[100];
clear();
int j,k;

for(int i=0;str[i]!='\0';i++){
        for(j =0;arr1[j]!='\0';j++);
        arr1[j]=str[i];
        //arr1[i+1]='\0';
        checkno(arr1);
       // printf("%d%d",i,j);
//printf("%s",arr1);

    }
final();


int ans=0;int f=0;int l=1;int temp=0;
//printf("%d",)
//printf("%s",symb);
for(int b=0;b<strlen(symb);b++)
    {
        temp=0;
     if(symb[b]=='+'){

            //printf("%d %d",intarr[f],intarr[l]);
          temp=  intarr[f]+intarr[l];
           //printf("  %d",temp);
     f++;
     l++;

     intarr[f]=temp;


     }
     else{
       // (symb[b]=='+'){
          temp=  intarr[f]-intarr[l];
     f++;
     l++;
     intarr[f]=temp;
     }
    }


printf("%d",intarr[f]);
//for(int a=0;a< strlen(strarr);a++)
  //  printf("%c",strarr[a]);

}








void checkno(char* arr1){

    if(strcmp(arr1,"zero")==0)
   {
strarr[ind]='0';
//printf("%c",strarr[ind]);

ind++;

    clear();
    return;
   }

else if(strcmp(arr1,"one")==0)
   {
strarr[ind]='1';

ind++;

    clear();
    return;
   }

 else  if(strcmp(arr1,"two")==0)
   {
strarr[ind]='2';
ind++;

    clear();
    return;
   }
   else  if(strcmp(arr1,"three")==0)
   {
strarr[ind]='3';
ind++;

    clear();
    return;
   }
   else  if(strcmp(arr1,"four")==0)
   {
strarr[ind]='4';
ind++;

    clear();
    return;
   }
   else  if(strcmp(arr1,"five")==0)
   {
strarr[ind]='5';
ind++;

    clear();
    return;
   }
   else  if(strcmp(arr1,"six")==0)
   {
strarr[ind]='6';
ind++;

    clear();
    return;
   }
   else  if(strcmp(arr1,"seven")==0)
   {
strarr[ind]='7';
ind++;

    clear();
    return;
   }
   else  if(strcmp(arr1,"eight")==0)
   {
strarr[ind]='8';
ind++;

    clear();
    return;
   }
   else  if(strcmp(arr1,"nine")==0)
   {
strarr[ind]='9';
ind++;

    clear();
    return;
   }




   else if(strcmp(arr1,"plus")==0){

    strarr[ind]='+';
    //printf("%c",strarr[ind]);
    ind++;
    clear();
    return;
   }

    else if(strcmp(arr1,"minus")==0){
    strarr[ind]='-';
    ind++;
    clear();
    return;
   }


}



void clear(){
for(int p=0;p<10;p++)
    arr1[p]='\0';}






void final(){
int ans=0;
int si=0;int ci=0;
int sum=0;
int n1;int n3;int z;int y;int x;
//printf("xcvb");

//for(int a=0;a<strlen(strarr);a++)
  //  printf("%c",strarr[a]);

for(x=0;x<=strlen(strarr);x++){
    if(strarr[x]=='+'){
        symb[si]='+';
        intarr[ci]=sum;
        sum=0;ci++;
        si++;
       // printf("%d%c",intarr[ci-1],symb[si-1]);
       // printf("  %d",sum);
       // printf(" zz ");
        //printf("%d%d",ci,si);
    }
    else if(strarr[x]=='-'){
        symb[si]='-';
        intarr[ci]=sum;
        sum=0;ci++;
        si++;
        //printf("%d",sum);
        //printf("xx");
      // printf("aa%d",intarr[ci-1]);
    }
    else if( strarr[x]=='\0'){
        intarr[ci]=sum;
        ci++;//printf("cc");
        //printf("%c",intarr[ci]);
        //printf("%d",sum);

    }



    else{
            sum=sum*10+(strarr[x]-'0');
            //printf("vv");

            //printf("%d",sum);

    }}

/*
for(int a=0;a<ci;a++)
    printf("n%d",intarr[a]);
for(int b=0;b<si;b++)
    printf("    %c",symb[b]);
*/

}
