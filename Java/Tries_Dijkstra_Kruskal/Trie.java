

public class Trie {

	TrieNode root;

	Trie() {
		root = new TrieNode(0);
	}

	private TrieNode locus(String str) { 
		// complete this method
		
		TrieNode tmp = root;
		TrieNode child;
		for (int i = 0; i < str.length(); i++) {
			Character c = str.charAt(i);
			child = tmp.edges.get(c);
			if (child == null)
				return tmp;
			else
				tmp = child;
		}
		return tmp;
	}

	public void insert(String str) { 
		// complete this method
		
		TrieNode parent = locus(str);
		for (int i = parent.depth; i < str.length(); i++) {
			TrieNode child = new TrieNode(parent.depth + 1);
			Character c = str.charAt(i);
			parent.edges.put(c, child);
			parent = child;
		}
	}

	public boolean search(String str) { 
		// complete this method
		return locus(str).depth == str.length();
	}

	public static String longestCommonSubstring(String str1, String str2) { 
		// complete this method
		
		Trie t = new Trie();
		for (int i = 0; i < str1.length(); i++) {
			String sub = str1.substring(i);
			t.insert(sub);
		}

		String lcs = new String();

		for (int i = 0; i < str2.length(); i++) {
			String sub = str2.substring(i);
			TrieNode v = t.locus(sub);
			if (v.depth > lcs.length())
				lcs = str2.substring(i, i + v.depth);
		}
		return lcs;

	}
}
