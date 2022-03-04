public class HW4Solution {
    // Big-O for this one is O(n)
    public boolean checkAnagrams(String str1, String str2) {
        if (null == str1 || str1.length() == 0 || str1.trim().length() == 0 ||
                str2.length() == 0 || str2.trim().length() == 0 || null == str2) {
            return false;
        }

        MyHashTable myHashTable = new MyHashTable();

        // Hash each character in string X into a hash table with its appropriate frequency (start with 1)
        // Assume that the case of both strings does not matter.
        for (char c : str1.trim().toLowerCase().toCharArray()) {
            if (c != ' ') {
                myHashTable.insert(c);
            }
        }

        for (char c : str2.trim().toLowerCase().toCharArray()) {
            if (c != ' ') {
                MyHashTable.DataNode node = myHashTable.find(c);

                if (node == null) {
                    return false; // Iterate over each character in string Y. If the character of Y is not in X, return false
                } else {
                    node.frequency--; //decrease the frequency of that character
                    if (node.frequency <= 0) {
                        myHashTable.delete(c);
                    }
                }
            }
        }

        return myHashTable.getTableSize() == 0; // After iterating, return true if the hash table is empty and false otherwise
    }

}
