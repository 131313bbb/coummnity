package work;

import java.util.Scanner;

import ds.graphic.ALGraph;
import ds.graphic.EdgeNode;
import ds.graphic.MGraph;
import ds.graphic.VexNode;

public class eeee {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	 MGraph mg=new MGraph();//创建邻接矩阵对象
     int vexnum=mg.vexnum;//获得顶点数目
      int edgenum=mg.edgenum;//获得边数目
      boolean isdirection =mg.isdirection;//是否为有向图
      ALGraph alg=new ALGraph(vexnum,edgenum,isdirection);
      for(int i=0;i<vexnum;i++){
          alg.vextex[i]=new VexNode(mg.vexs[i]);
    }
     // EdgeNode p=null;
      //建立邻接表边链表
      for(int i=0;i<vexnum;i++){
    	
            for(int j=0;j<vexnum;j++){
                    int w=mg.edges[i][j];
                   if(w>0&&w<1000){
                	   EdgeNode e=new EdgeNode(j,mg.edges[i][j]);
                	   if(alg.vextex[i].firstedge==null) {
                		   alg.vextex[i].firstedge=e;
                	   }else {
                		   EdgeNode num=alg.vextex[i].firstedge;
                		   while(num.next!=null) {
                			   num=num.next;
                		   }
                		   num.next=e;
                	   }
                	   

                          
                  }
          }
     }
    //输出邻接表图存储示例图
    alg.pntALGraph();

}
}
