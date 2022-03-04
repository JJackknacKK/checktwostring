public class MyHashTable {

    /**
     * internal class for data storage
     */
    class DataNode {
        char data;
        int frequency;

        public DataNode(char _data) {
            this.data = _data;
            this.frequency = 1;
        }
    }


    private static final int DEFAULT_TABLE_SIZE = 1;
    private static final int EXPAND_MULTIPLIER = 8;

    private DataNode[] hashArray;
    private int tableSize; // definition of hash table size
    private int maxCapacity; // definition of hash max capacity

    /**
     * The only constructor
     */
    public MyHashTable(){
        this.tableSize = 0;
        this.maxCapacity = DEFAULT_TABLE_SIZE; //Start the hash table with a size of 1,
        this.hashArray = new DataNode[DEFAULT_TABLE_SIZE];
    }

    /**
     * hash functions - O(1)
     * @param c
     * @return
     */
    public int hash(char c){
        // Use the following hash function: Math.abs(Character.valueOf(c) % tableSize)
        return Math.abs(Character.valueOf(c) % this.maxCapacity);
    }

    /**
     * insert  - best case - O(1), worst case - O(n)
     * @param item
     */
    public void insert(char item){
        if(this.tableSize == this.maxCapacity) {
            expandTable();
        }
        char key = item;
        DataNode node = insertHelper(key, this.hashArray);
        if (node.frequency == 1) {
            this.tableSize++;
        }
    }

    /**
     * Internal function, expand existing table by EXPAND_MULTIPLIER- O(n)
     */
    private void expandTable() {
        this.maxCapacity = this.tableSize * EXPAND_MULTIPLIER;
        DataNode[] tmp = new DataNode[this.maxCapacity];
        for(int i = 0; i < this.tableSize; i++){
            if(hashArray[i] != null) {
                char key = hashArray[i].data;
                DataNode node = insertHelper(key, tmp);
                node.frequency = hashArray[i].frequency;
            }
        }
        this.hashArray = tmp;
    }

    /**
     * Internal function for best case - O(1), worst case - O(n)
     * @param key
     * @param table
     * @return
     */
    private DataNode insertHelper(char key, DataNode[] table) {
        int hashCode = this.hash(key);
        //if same key exist, find next available position
        while(table[hashCode] != null){
            if (table[hashCode].data == key) {
                table[hashCode].frequency++;
                return table[hashCode];
            }
            ++hashCode;
            hashCode %= this.maxCapacity;
        }
        DataNode newNode = new DataNode(key);
        table[hashCode] = newNode;
        return newNode;
    }

    /**
     * delete - best case - O(1), worst case - O(n)
     * @param key
     * @return
     */
    public DataNode delete(char key){
        int hashCode = hash(key);
        while(hashArray[hashCode] != null){
            if(hashArray[hashCode].data == key){
                DataNode temp = hashArray[hashCode];
                hashArray[hashCode] = null;
                this.tableSize--;
                return temp;
            }
            ++hashCode;
            hashCode %= this.maxCapacity;
        }
        return null;
    }

    /**
     * find - best case - O(1), worst case - O(n)
     * @param key
     * @return
     */
    public DataNode find(char key){
        int hashCode = hash(key);
        while(hashArray[hashCode] != null){
            if(hashArray[hashCode].data == key) {
                return hashArray[hashCode];
            }
            ++hashCode;
            hashCode %= this.maxCapacity;
        }
        return null;
    }

    /**
     * print all data - O(n)
     */
    public void printData(){
        for(int i = 0; i < this.maxCapacity; i++){
            if(hashArray[i] != null)
                System.out.print(hashArray[i].data + " : " + hashArray[i].frequency + ", ");
        }
        System.out.println();
    }

    /**
     * Get current size of the hash table - O(1)
     */
    public int getTableSize() {
        return tableSize;
    }
}
