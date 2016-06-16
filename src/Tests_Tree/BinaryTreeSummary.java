package Tests_Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

import Utils.TreeNode;
import Utils.U;

public class BinaryTreeSummary {

	public BinaryTreeSummary() {

	}

	/**
	 * ��������еĽڵ�����ݹ�ⷨ�� O(n) ��1�����������Ϊ�գ��ڵ����Ϊ0 ��2�������������Ϊ�գ��������ڵ���� = �������ڵ���� +
	 * �������ڵ���� + 1
	 */
	public int getNodeNumRec(TreeNode root) {
		if (root == null)
			return 0;
		return 1 + getNodeNumRec(root.right) + getNodeNumRec(root.left);
	}

	/**
	 * ��������еĽڵ���������ⷨO(n)������˼��ͬLevelOrderTraversal��
	 * ����һ��Queue����Java���������LinkedList��ģ��
	 */
	public int getNodeNum(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode cur;
		int nodeNum = 1;
		queue.add(root);
		while (!queue.isEmpty()) {
			cur = queue.poll();
			if (cur.left != null) {
				queue.add(cur.left);
				nodeNum++;
			}
			if (cur.right != null) {
				queue.add(cur.right);
				nodeNum++;
			}
		}

		return nodeNum;
	}

	/**
	 * �����������ȣ��߶ȣ� �ݹ�ⷨ�� O(n) ��1�����������Ϊ�գ������������Ϊ0 ��2�������������Ϊ�գ������������ =
	 * max(��������ȣ� ���������) + 1
	 */

	public int getDepthRec(TreeNode root) {
		if (root == null)
			return 0;
		else
			return 1 + Math.max(getDepthRec(root.left), getDepthRec(root.right));

	}

	/**
	 * �����������ȣ��߶ȣ� �����ⷨ�� O(n)
	 */
	public int getDepth(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		TreeNode cur = root;
		int depth = 0;
		int levelSize;// ��ǰ��node����
		while (!queue.isEmpty()) {
			levelSize = queue.size();
			while (levelSize > 0) {
				cur = queue.poll();
				if (cur.left != null) {
					queue.add(cur.left);
				}
				if (cur.right != null) {
					queue.add(cur.right);
				}
				levelSize--;
			}
			depth++;
		}
		return depth;
	}

	/**
	 * ��������ݹ�ⷨ ��1�����������Ϊ�գ��ղ����� ��2�������������Ϊ�գ�������������������ʸ��ڵ㣬�������������
	 */
	public void LDRRec(TreeNode root) {
		if (root == null)
			return;
		LDRRec(root.left);
		U.p(root.val);
		LDRRec(root.right);
	}

	/**
	 * ������������ⷨ ����ջ�ȰѸ��ڵ���������Ӷ���ӵ�ջ�ڣ� Ȼ�����ջ��Ԫ�أ��ٴ���ջ��Ԫ�ص�������
	 * http://www.youtube.com/watch?v=50v1sJkjxoc
	 * 
	 * ����һ�ַ����ܲ��õݹ��ջ�����������������ķ��������鷳�Ժ���
	 * http://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion-and
	 * -without-stack/
	 */
	public void LDR(TreeNode root) {
		if (root == null) {
			return;
		}
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (true) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}
			if (stack.isEmpty()) {
				break;
			}
			// no left node now
			cur = stack.pop();
			U.p(cur.val);
			cur = cur.right;
		}
	}

	/**
	 * ǰ������ݹ�ⷨ
	 */
	public void DLRRec(TreeNode root) {
		if (root == null)
			return;
		U.p(root.val);
		DLRRec(root.left);
		DLRRec(root.right);
	}

	/**
	 * ǰ����������ⷨ
	 */

	public void DLR(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		// while (true) {
		// while (cur != null) {
		// U.p(cur.val);
		// stack.push(cur);
		// cur = cur.left;
		// }
		// if (stack.isEmpty())
		// break;
		// cur = stack.pop().right;
		// }

		// Method2: ��һ������stack�����ǰ��Һ��ӷŽ�ջ
		// http://www.youtube.com/watch?v=uPTCbdHSFg4
		stack.push(cur);
		while (!stack.isEmpty()) {
			cur = stack.pop();
			U.p(cur.val);
			if (cur.right != null)
				stack.push(cur.right);
			if (cur.left != null)
				stack.push(cur.left);
		}
	}

	public void LRDRec(TreeNode root) {
		if (root == null)
			return;
		LRDRec(root.left);
		LRDRec(root.right);
		U.p(root.val);
	}

	// ��û�뵽�ķ���������
	/**
	 * ������������ⷨ http://www.youtube.com/watch?v=hv-mJUs5mvU
	 * ������stack��һ������pop��ջ������ڶ���stack�����ڷ�ת������������δ������ҽڵ㣬
	 * 
	 * ��һ��stack�����˼�Ϊ����
	 */
	public void LRD(TreeNode root) {
		if (root == null)
			return;
		Stack<TreeNode> stack = new Stack<>();
		Stack<TreeNode> output = new Stack<>();
		TreeNode cur = root;
		stack.push(cur);

		while (!stack.isEmpty()) {// ȷ������Ԫ�ض�����תת�Ƶ��ڶ���stack
			// pop��ջ��
			cur = stack.pop();
			output.push(cur);

			// ��ջ��Ԫ�ص������ӽڵ�ֱ�������һ��stack
			if (cur.left != null) {
				stack.push(cur.left);
			}
			if (cur.right != null) {
				stack.push(cur.right);
			}
		}
		// ��������ڶ���stack����Ϊ�������
		while (!output.isEmpty()) {
			cur = output.pop();
			U.p(cur.val);
		}
	}

	/**
	 * �ֲ����������������δ������£��������ң�����
	 * �൱�ڹ������������ʹ�ö���ʵ�֡����г�ʼ���������ڵ�ѹ����С������в�Ϊ�գ��������²���������һ���ڵ�
	 * �����ʣ������ӽڵ�����ӽڵ㲻Ϊ�գ�����ѹ�����
	 */

	public void levelTraversal(TreeNode root) {
		if (root == null)
			return;
		Queue<TreeNode> queue = new LinkedList<>();
		int levelSize;
		TreeNode cur = root;
		queue.add(cur);
		while (!queue.isEmpty()) {
			levelSize = queue.size();
			while (levelSize > 0) {
				cur = queue.poll();
				System.out.print(cur.val + " ");
				levelSize--;
				if (cur.left != null) {
					queue.add(cur.left);
				}
				if (cur.right != null) {
					queue.add(cur.right);
				}
			}
			System.out.println();
		}
	}

	/***
	 * �ֲ�������������ݹ飩 �������˻��õݹ�ȥ��level traversal
	 * ����˼������һ�����ArrayList�����������ÿһ���ArrayList�� ���ArrayList��size��level�й�ϵ
	 * 
	 * ������Ŀǰ��������õĵݹ�ⷨ�� *
	 */
	public void levelTraversalRec(TreeNode root) {

		ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
		dfs(root, 0, arr);
		System.out.println(arr);
	}

	public void dfs(TreeNode root, int level, ArrayList<ArrayList<Integer>> arr) {
		if (root == null)
			return;
		if (level >= arr.size())
			arr.add(level, new ArrayList<Integer>());
		arr.get(level).add(root.val);
		dfs(root.left, level + 1, arr);
		dfs(root.right, level + 1, arr);
	}

	/**
	 * converting a binary search tree to doubly linked list
	 */

	public static void main(String args[]) {
		BinaryTreeSummary bts = new BinaryTreeSummary();
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 = new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.right = t6;
		bts.levelTraversalRec(t1);
	}

}
