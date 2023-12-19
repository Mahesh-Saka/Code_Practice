package DataStructure;


import java.util.ArrayList;
import java.util.Arrays;

class NodeItem {
    public int data;
    public NodeItem next;

    NodeItem() {
        this.data = 0;
        this.next = null;
    }

    NodeItem(int data) {
        this.data = data;
        this.next = null;
    }

    NodeItem(int data, NodeItem next) {
        this.data = data;
        this.next = next;
    }
}

public class Node {

    public static void main(String[] args) {
        NodeItem nodeItem5 = new NodeItem(6);
        NodeItem nodeItem4 = new NodeItem(5, nodeItem5);
        NodeItem nodeItem3 = new NodeItem(4, nodeItem4);
        NodeItem nodeItem2 = new NodeItem(3, nodeItem3);
        NodeItem nodeItem1 = new NodeItem(2, nodeItem2);
        NodeItem nodeItem = new NodeItem(1, nodeItem1);

        NodeItem nodeItem6 = rotate(nodeItem, 3);
        while (nodeItem6 != null) {
            System.out.println(nodeItem6.data);
            nodeItem6 = nodeItem6.next;
        }

    }

    public static NodeItem rotate(NodeItem head, int k) {
       /* ArrayList<Integer> list = new ArrayList<>();
        int mTotalSize = 0;
        while (head != null) {
            head = head.next;
        }
        ArrayList<Integer> list1 = new ArrayList<>(list.subList(list.size() - k, list.size()));
        int i = (list.size() - 1) - k;
        NodeItem next = null, tempNode = null, mainNext = null, headMain = null, tempMain = null;
        while (i >= 0) {
            tempNode = new NodeItem(list.get(i), next);
            next = tempNode;
            i--;
        }
        i = list1.size() - 1 ;
        while (i >= 0) {
            tempMain = new NodeItem(list1.get(i), mainNext);
            mainNext = tempMain;
            if(headMain==null){
                headMain = tempMain;
            }
            i--;
        }
        headMain.next = tempNode;
        return tempMain;*/
        int mTotalSize = 0;
        NodeItem mHead = head, mTempHead = head;
        NodeItem mNewHead = null, mNewTempHead = null, mLastHead = null;
        while (head != null) {
            mTotalSize++;
            head = head.next;
        }
        int mNewSize = mTotalSize - k;
        while (mTempHead.next != null && mNewSize > 0) {
            mNewTempHead = mTempHead;
            mTempHead = mTempHead.next;
            mNewSize--;
        }
        mNewHead = mNewTempHead.next;
        NodeItem last = mNewHead;
        while (last.next != null) {
            last = last.next;
        }
        last.next = mHead;
        NodeItem next = mNewHead;
        NodeItem lastIndex =null;
        while (next.next != null && mTotalSize > 0) {
            mLastHead = next;
            next = next.next;
            mTotalSize--;
        }
        mLastHead.next = null;
        return mNewHead;
    }
}
