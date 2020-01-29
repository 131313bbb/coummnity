package work;

import java.util.Scanner;

import ds.graphic.MGraph;

public class Main1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MGraph mg = new MGraph();
		int start = sc.nextInt();
		int end = sc.nextInt();
		distance(start, end, mg);
		

	}

	private static int[] distance(int start, int end, MGraph mg) {
		// TODO Auto-generated method stub
		// 初始化，第一个顶点求出
		int[] shortest = new int[mg.vexnum];
		boolean[] visited = new boolean[mg.vexnum];
		shortest[start] = 0;
		visited[start] = true;

		// 存放从start到其他各节点的最短路径
		String[] path = new String[mg.vexnum];
		for (int i = 0; i < mg.vexnum; i++) {
			path[i] = new String(mg.vexs[start].vname + "-->" + mg.vexs[i].vname);
		}
		for (int count = 0; count != mg.vexnum - 1; count++) {
			// 选出一个距离初始顶点最近的为标记顶点
			int k = -1;
			int min = -1;
			for (int i = 0; i < mg.vexnum; i++)// 遍历每一个顶点
			{
				if (!visited[i] && mg.edges[start][i] != -1) // 如果该顶点未被遍历过且与orig相连
				{
					if (min == -1 || min > mg.edges[start][i]) // 找到与orig最近的点
					{
						min = mg.edges[start][i];
						k = i;
					}
				}
			}
			// 正确的图生成的矩阵不可能出现K== M的情况
			if (k == -1) {
				System.out.println("the input map matrix is wrong!");
				return null;
			}
			shortest[k] = min;
			visited[k] = true;
			// 以k为中心点，更新oirg到未访问点的距离
			for (int i = 0; i < mg.vexnum; i++) {
				if (!visited[i] && mg.edges[k][i] != -1) {
					int callen = min + mg.edges[k][i];
					if (mg.edges[start][i] == -1 || mg.edges[start][i] > callen) {
						mg.edges[start][i] = callen;
						path[i] = path[k] + "-->" + mg.vexs[i].vname;
					}
				}
			}
		}

		for (int i = 0; i < mg.vexnum; i++)
			if (i == end)
				System.out.println(mg.vexs[start].vname + "-->" + mg.vexs[i].vname + " distance " + shortest[i] + " "
						+ "path:" + path[i]);

		return shortest;
	}

}

