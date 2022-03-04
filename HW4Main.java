public class HW4Main {
    public static void main(String[] args) {
//        MyHashTable myHashTable = new MyHashTable();
//        String str1 = "data";
//
//
//        for(char c : str1.toLowerCase().toCharArray()) {
//            myHashTable.insert(c);
//        }
//        myHashTable.printData();
//        System.out.println("size: " + myHashTable.getTableSize());
//
//        MyHashTable.DataNode node = myHashTable.find('d');
//        System.out.println(node.frequency);

        HW4Solution hw4Solution = new HW4Solution();
        String str1 = "data";
        String str2 = "aatd";
        System.out.println("test case 1: " + hw4Solution.checkAnagrams(str1, str2));

        str1 = null;
        str2 = "aatd";
        System.out.println("test case 2: " + hw4Solution.checkAnagrams(str1, str2));

        str1 = "";
        str2 = "aatd";
        System.out.println("test case 3: " + hw4Solution.checkAnagrams(str1, str2));

        str1 = "    ";
        str2 = "aatd";
        System.out.println("test case 4: " + hw4Solution.checkAnagrams(str1, str2));

        str1 = "da   ta  ";
        str2 = "aatd";
        System.out.println("test case 5: " + hw4Solution.checkAnagrams(str1, str2));

        str1 = "iiiiiiiiiiifsdfsdafsdfdfasdfasdhxcbxnmnmbhjfsdfjklhjkfhjkl;sdhfsdjkfhsdjk";
        str2 = "aatd";
        System.out.println("test case 6: " + hw4Solution.checkAnagrams(str1, str2));

        str1 = "iiiii              iiiiiifsdfsdafsdfdfasdfasdhxcbxnmnmbhjfsdfjklhjkfhjklsdhfsdjkfhsdjk       ";
        str2 = "iiiiiiiiiiifsdfsd          afsdfdfasdfasdhxcbxnmnmbhjfsdf      jklhjkfhjklsdhfsdjkfhsdjk";
        System.out.println("test case 7: " + hw4Solution.checkAnagrams(str1, str2));

        str1 = "woshi shei";
        str2 = "nishi shei";
        System.out.println("test case 8: " + hw4Solution.checkAnagrams(str1, str2));

        str1 = "    ";
        str2 = "   ";
        System.out.println("test case 9: " + hw4Solution.checkAnagrams(str1, str2));

        str1 = "uytrewq";
        str2 = "qwertyu";
        System.out.println("test case 10: " + hw4Solution.checkAnagrams(str1, str2));

        str1 = "iiiuuussshhhlamamama";
        str2 = "iiiuuusss   hhhl   amamama";
        System.out.println("test case 11: " + hw4Solution.checkAnagrams(str1, str2));


    }
}
