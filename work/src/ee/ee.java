package ee;

import java.util.Scanner;

import ds.graphic.MGraph;
import ds.stack.LinkStack;

public class ee {
    public static  int distance[];
    public static  int book[];
    public static  int path[];
    public static int s,e;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        MGraph mg=new MGraph();
        distance=new int[mg.vexnum];
        book=new int[mg.vexnum];
        path=new int[mg.vexnum];
        s=sc.nextInt();
        e=sc.nextInt();
        for(int i=0;i<mg.vexnum;i++)
        {
            distance[i]=mg.MAXSIZE;
            path[i]=s;//注意
        }
        for(int i=0;i<mg.vexnum;i++)
        {
            distance[i]=mg.edges[s][i];
        }
        distance[s]=0;
        book[s]=1;
        path[s]=-1;//注意
        mPath(mg);
        System.out.print(mg.vexs[s].vname+"-->"+mg.vexs[e].vname+" distance "+distance[e]+" path:");
        LinkStack<Integer> st=new LinkStack();//注意
        int p=e;
        while(path[p]!=-1)
        {
        	st.push(p);
        	p=path[p];
        }
        st.push(p);//注意
        if(!st.empty())
        	System.out.print(mg.vexs[st.pop()].vname);
        while(!st.empty())
        {
        	System.out.print("-->"+mg.vexs[st.pop()].vname);
        }
        System.out.println();
    }
    
    public static void mPath(MGraph mg)
    {
        while(true)
        {
            int index=-1;
            int min=mg.MAXSIZE;
            for(int i=0;i<mg.vexnum;i++)
            {
                if(book[i]==0&&distance[i]<min)
                {
                    min=distance[i];
                    index=i;
                }
            }
            if(index==-1)
                break;
            book[index]=1;
            for(int i=0;i<mg.vexnum;i++)
            {
                if(book[i]==0&&mg.edges[index][i]!=mg.MAXSIZE&&min+mg.edges[index][i]<distance[i])
                {
                	distance[i]=min+mg.edges[index][i];
                	path[i]=index;
                }
            }
        }
    }
}

