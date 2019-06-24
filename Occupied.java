public class Occupied{
int arr[][]=new int[701][1002];

public void line(int x1,int y1,int wt,int ht)
{
	int a,b;
	int c,d;
	c=x1+wt;
	d=y1+ht;
	for( b=y1;b<=d;b++)
		for(a=x1;a<=c;a++ )
			arr[b][a]=1;

}
public void eatenDot(int x,int y)
{
arr[y][x]=0;
}
public void dot(int x,int y)
{
arr[y][x]=2;
}
public int ck(int x1,int y1){

	return arr[y1][x1];              //0->nothing   1->wall       2->point
}
public void clearDot(int x,int y){
	arr[y][x]=0;
}

}
