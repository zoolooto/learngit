#include<stdio.h>
#include<stdlib.h>
#include<time.h>
#define M 8
#define N 280
typedef struct page {

	int num;
	int time;
} page;
page mm[M];
int queue1[N],queue2[N];
int K=0,S=0;
int pos=0;
void init() {
	int i;
	for(i=0; i<M; i++) {
		mm[i].num=-1;
		mm[i].time=0;
	}

}
int getmax() {
	int max=-1;
	int i;
	for(i=0; i<M; i++) {
		if(mm[i].time>max) {
			max=mm[i].time;
			pos=i;
		}
	}
	return pos;

}
int equation(int fold) {  //页面是否在内存
	int i;
	for(i=0; i<M; i++) {
		if(mm[i].num==fold)
			return i;
	}
	return -1;
}
int check() {            //内存是否占满
	int i;
	for(i=0; i<M; i++) {
		if(mm[i].num==-1) {
			return i;
		}
		return -1;
	}
}
void fifo(int fold) {
	int i;
	int a,b,c;
	a=equation(fold);
	if(a!=-1) {}
	else {
		b=check();
		if(b!=-1) {
			mm[b].num=fold;
		} else {
			c=getmax();
			mm[c].num=fold;
			mm[c].time=0;
		}
		queue1[K++]=fold;
	}
	for(i=0; i<M; i++) {
		if(mm[i].num!=-1) {
			mm[i].time++;
		}
	}
}
void lru(int fold) {
	int i,a,b,p;
	a=equation(fold);
	if(a!=-1) {
		if(a==3)
			return;
		else {
			p=equation(-1);
			if(p==-1) {
				for(; a<3; a++)
					mm[a].num=mm[a+1].num;
				mm[3].num=fold;
			} else if(p<=3) {
				for(; a<p-1; a++)
					mm[a].num=mm[a+1].num;
				mm[a].num=fold;
			}
		}
	} else {
		b=check();
		if(b!=-1)
			mm[b].num=fold;
		else {
			for(i=0; i<3; i++)
				mm[i].num=mm[i+1].num;
			mm[3].num=fold;
		}
		queue2[S++]=fold;
	}
}
void main() {
	int a[N],b[N];
	int i;
	init();
	srand((int)time(0));
	printf("input N page number\n");
	for(i=0; i<N; i++) {
		a[i]=1+(int)(10.0*rand()/(RAND_MAX+1.0));
		printf(" %d",a[i]);
	}
	//FIFO
	for(i=0; i<N; i++) {
		b[i]=a[i];
	}
	for(i=0; i<N; i++) {
		fifo(b[i]);
	}
	printf("\nFiFO的调入队列为:");
	for(i=0; i<K; i++)
		printf("%3d",queue1[i]);
	printf("\n缺页次数为%5d\n 缺页率为：%6.2f\n",K,(float)K/N);
	//lRU
//	init();
//	for(i=0;i<N;i++)
//	b[i]=a[i];
//	for(i=0;i<N;i++)
//	lru(b[i]);
//	printf("LRU的调入队列为");
//	for(i=0;i<S;i++)
//	printf("%3d",queue2[i]);
//	printf("\n缺页次数为%5d\n 缺页率为：%6.2f\n",S,(float)S/N);
}
