/*****************************************************
 * interface List -- subset of actual Java List interface
 * Specifies actions a List must be able to perform.
 *****************************************************/

public interface List<E> { 

    //add node to list, containing input E as its data
    public boolean add( E x ); 

    //inserts a node containing s at position I
    public void add( int i, E s ); 

    //removes the node at position i and returns its cargo
    public E remove( int i );

    //return data in element at position i
    public E get( int i ); 

    //overwrite data in element at position i
    public E set( int i, E x ); 

    //return length of list
    public int size(); 

}//end interface
