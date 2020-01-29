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
		// ��ʼ������һ���������
		int[] shortest = new int[mg.vexnum];
		boolean[] visited = new boolean[mg.vexnum];
		shortest[start] = 0;
		visited[start] = true;

		// ��Ŵ�start���������ڵ�����·��
		String[] path = new String[mg.vexnum];
		for (int i = 0; i < mg.vexnum; i++) {
			path[i] = new String(mg.vexs[start].vname + "-->" + mg.vexs[i].vname);
		}
		for (int count = 0; count != mg.vexnum - 1; count++) {
			// ѡ��һ�������ʼ���������Ϊ��Ƕ���
			int k = -1;
			int min = -1;
			for (int i = 0; i < mg.vexnum; i++)// ����ÿһ������
			{
				if (!visited[i] && mg.edges[start][i] != -1) // ����ö���δ������������orig����
				{
					if (min == -1 || min > mg.edges[start][i]) // �ҵ���orig����ĵ�
					{
						min = mg.edges[start][i];
						k = i;
					}
				}
			}
			// ��ȷ��ͼ���ɵľ��󲻿��ܳ���K== M�����
			if (k == -1) {
				System.out.println("the input map matrix is wrong!");
				return null;
			}
			shortest[k] = min;
			visited[k] = true;
			// ��kΪ���ĵ㣬����oirg��δ���ʵ�ľ���
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

