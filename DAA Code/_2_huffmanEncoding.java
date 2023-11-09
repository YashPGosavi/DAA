import java.util.*;

/*
1. Huffman encoding is a popular algorithm used for lossless data compression. 
2. The algorithm assigns variable-length codes to input characters, 
with shorter codes assigned to more frequent characters and longer codes assigned to less frequent characters. 
3. This results in efficient compression, where the most common characters are represented by shorter codes,reducing the overall size of the encoded data.
 */

public class _2_huffmanEncoding{

    static class Node implements Comparable<Node>{
        int frequency;
        char data;
        Node left;
        Node right;

        public Node(char data, int frequency){
            this.data = data;
            this.frequency = frequency;
            this.left = null;
            this.right = null;
        }

        @Override
        public int compareTo(Node other){
            return this.frequency - other.frequency;
        }
        
    }

    public static void huffamanBuilder(HashMap<Character,Integer> hm){

        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(char c : hm.keySet()){
            pq.add(new Node(c, hm.get(c)));
        }

        while(pq.size()>1){
            Node lefNode = pq.poll();

            Node rightNode = pq.poll();

            Node newNode = new Node('$',lefNode.frequency+rightNode.frequency);

            newNode.left = lefNode;

            newNode.right = rightNode;

            pq.add(newNode);

        }

        Node root = pq.poll();
        encoder(root," ");

    }

    private static void encoder(Node root, String encoding) {
        if(root == null){
            return;
        }

        if(root.data != '$'){
            System.out.println(root.data+" = "+encoding);
        }

        encoder(root.left, encoding+"0");
        encoder(root.right, encoding+"1");
    }

    public static void main(String []args){
        String str = "aaaaaabbbbbcccccddd";

        HashMap<Character,Integer> hm = new HashMap<>();

        for(char c: str.toCharArray()){
            hm.put(c, hm.getOrDefault(c,0)+1);
        }

        huffamanBuilder(hm);
    }
}