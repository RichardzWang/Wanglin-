/*****************************************************
 * interface List -- subset of actual Java List interface
 * Specifies actions a List must be able to perform.
 *****************************************************/

public interface List { 

    //add node to list, containing input Object as its data
    public boolean add( Object x ); 

    //inserts a node containing s at position I
    public void add( int i, Object s ); 

    //removes the node at position i and returns its cargo
    public Object remove( int i );

    //return data in element at position i
    public Object get( int i ); 

    //overwrite data in element at position i
    public Object set( int i, Object x ); 

    //return length of list
    public int size(); 

}//end interface
