package work;

import java.util.Scanner;

import ds.graphic.ALGraph;
import ds.graphic.EdgeNode;
import ds.graphic.MGraph;
import ds.graphic.VexNode;

public class eeee {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	 MGraph mg=new MGraph();//�����ڽӾ������
     int vexnum=mg.vexnum;//��ö�����Ŀ
      int edgenum=mg.edgenum;//��ñ���Ŀ
      boolean isdirection =mg.isdirection;//�Ƿ�Ϊ����ͼ
      ALGraph alg=new ALGraph(vexnum,edgenum,isdirection);
      for(int i=0;i<vexnum;i++){
          alg.vextex[i]=new VexNode(mg.vexs[i]);
    }
     // EdgeNode p=null;
      //�����ڽӱ������
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
    //����ڽӱ�ͼ�洢ʾ��ͼ
    alg.pntALGraph();

}
}
