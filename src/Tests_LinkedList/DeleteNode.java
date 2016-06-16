package Tests_LinkedList;

import Utils.ListNode;
import Utils.U;

public class DeleteNode {

	public DeleteNode() {
		ListNode n1 = new ListNode(0);
		ListNode n2 = new ListNode(1);

		n1.next = n2;

		deleteNode(n1);
		U.p(n1.val);
	}

	public void deleteNode(ListNode node) {

		node.val = node.next.val;
		node.next = node.next.next;

	}

}
