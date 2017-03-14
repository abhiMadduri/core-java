package com.java.trie;

import java.util.Iterator;
import java.util.LinkedList;

//stores data in such a way that it can be retrieved faster and improve the performance.
//real-time examples: Dictionary, Searching contacts in mobile
//You can insert words in trie and its children linked list will represent its child nodes and isEnd defines if it is end for the word
public class TrieDS {

    class TrieNode {
        char data;
        boolean isEnd;
        int count;
        LinkedList childList;

        /* Constructor */
        public TrieNode(char c) {
            childList = new LinkedList();
            isEnd = false;
            data = c;
            count = 0;
        }

        public TrieNode getChild(char c) {
            /*if (childList != null)
                for (TrieNode eachChild : childList)
                    if (eachChild.data == c)
                        return eachChild;*/
            return null;
        }
    }

    private TrieNode root;

    /* Constructor */
    public TrieDS() {
        root = new TrieNode(' ');
    }

    /**
     * Algorithm for inserting word in Trie structure:
        If word already exists, return it.
        Make current node as root trie node
        Iterate over each character(lets say c) of word.
        get child trie nodes for current node
        If child node exists and is equal to character c then make it current node and increment the count.
        If child node does not exist, then create a new trie node with character c and add it to current node childList and change current node to newly created trie node.
        When you reach at end of the word, make isEnd = true.
     * @param word
     */
    /* This function is used to insert a word in trie */
    public void insert(String word) {
        if (search(word) == true)
            return;
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode child = current.getChild(ch);
            if (child != null)
                current = child;
            else {
                // If child not present, adding it io the list
                current.childList.add(new TrieNode(ch));
                current = current.getChild(ch);
            }
            current.count++;
        }
        current.isEnd = true;
    }

    /**
     * Algorithm for searching a word in Trie data structure:
        For each character of word , see if child node exists for it.
        If child node does not exists, return false
        If character exists, repeat above step
        When you reach at end of the String and current.isEnd is true then return true else return false.
     * @param word
     * @return
     */
    /* This function is used to search a word in trie */
    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (current.getChild(ch) == null)
                return false;
            else
                current = current.getChild(ch);
        }
        if (current.isEnd == true)
            return true;
        return false;
    }

    /* This function is used to remove function from trie */
    public void remove(String word) {
        if (search(word) == false) {
            System.out.println(word + " does not present in trien");
            return;
        }
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            TrieNode child = current.getChild(ch);
            if (child.count == 1) {
                current.childList.remove(child);
                return;
            } else {
                child.count--;
                current = child;
            }
        }
        current.isEnd = false;
    }

    public static void printAllWordsInTrie(TrieNode root, String s) {
        TrieNode current = root;
        if (root.childList == null || root.childList.size() == 0)
            return;
        Iterator iter = current.childList.iterator();
        while (iter.hasNext()) {
            TrieNode node = (TrieNode) iter.next();
            s += node.data;
            printAllWordsInTrie(node, s);
            if (node.isEnd == true) {
                System.out.print(" " + s);
                s = s.substring(0, s.length() - 1);
            } else {
                s = s.substring(0, s.length() - 1);
            }
        }

    }

    public static void main(String[] args) {
        TrieDS t = new TrieDS();
        t.insert("dear");
        t.insert("deal");
        t.insert("do");
        t.insert("he");
        t.insert("hen");
        t.insert("heat");

        System.out.println("hen present in trie : " + t.search("hen"));
        System.out.println("hear present in trie : " + t.search("hear"));
        System.out.println("deal present in trie : " + t.search("deal"));
        System.out.println("========================");
        System.out.println("Printing all word present in trie : ");
        printAllWordsInTrie(t.root, "");
    }
}
