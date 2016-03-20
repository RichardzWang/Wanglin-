/*****************************************************
 * class DLLNode<E>
 * Implements a node, for use in lists and other container classes.
 *****************************************************/

public class DLLNode<E> {

    private E _cargo;    //cargo may only be of type String
    private DLLNode<E> _nextNode, _prevNode; //pointers to next, prev DLLNodes


    // constructor -- initializes instance vars
    public DLLNode( E value, DLLNode<E> prev, DLLNode<E> next ) {
	_cargo = value;
	_nextNode = next;
	_prevNode = prev;
    }


    //--------------v  ACCESSORS  v--------------
    public E getCargo() { return _cargo; }

    public DLLNode<E> getNext() { return _nextNode; }

    public DLLNode<E> getPrev() { return _prevNode; }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public E setCargo( E newCargo ) {
	E foo = getCargo();
	_cargo = newCargo;
	return foo;
    }

    public DLLNode<E> setNext( DLLNode<E> newNext ) {
	DLLNode<E> foo = getNext();
	_nextNode = newNext;
	return foo;
    }

    public DLLNode<E> setPrev( DLLNode<E> newPrev ) {
	DLLNode<E> foo = getPrev();
	_prevNode = newPrev;
	return foo;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString() { return _cargo.toString(); }


    //main method for testing
    public static void main( String[] args ) {

	//Below is an exercise in creating a linked list...

	/*********************
	//Create a node
	DLLNode<E> first = new DLLNode<E>( "cat", null );

	//Create a new node after the first
	first.setNext( new DLLNode<E>( "dog", null ) );

	//Create a third node after the second
	first.getNext().setNext( new DLLNode<E>( "cow", null ) );

	DLLNode<E> temp = first; 
	while( temp != null ) {
	    System.out.println( temp );
	    temp = temp.getNext();
	}
	***********************/
    }//end main

}//end class DLLNode<E>
