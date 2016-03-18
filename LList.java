/*****************************************************
 * class LList
 * Implements a linked list
 * Version 03 uses doubly-linked nodes
 *****************************************************/

public class LList<E> implements List { //your List.java must be in same dir

    //instance vars
    private DLLNode<E> _head, _tail; //pointers to first and last nodes
    private int _size;

    // constructor -- initializes instance vars
    public LList( ) {
	_head = _tail = null; //at birth, a list has no elements
	_size = 0;
    }


    //--------------v  List interface methods  v--------------

    //insert a node at the end
    public boolean add( Object newVal ) { 
	addLast( newVal );
	return true; //per Java API spec
    } 


    //insert a node containing newVal at position index
    public void add( int index, Object newVal ) {

	if ( index < 0 || index > size() )
	    throw new IndexOutOfBoundsException();

	else if ( index == size() ) 
	    addLast( newVal );

	DLLNode<E> newNode = new DLLNode<E>( newVal, null, null );

	//if index==0, insert node before head node
	if ( index == 0 ) 
	    addFirst( newVal );
	else {
	    DLLNode<E> tmp1 = _head; //create alias to head

	    //walk tmp1 to node before desired node
	    for( int i=0; i < index-1; i++ )
		tmp1 = tmp1.getNext();

	    //init a pointer to node at insertion index
	    DLLNode<E> tmp2 = tmp1.getNext(); 

	    //insert new node
	    newNode.setNext( tmp2 );
	    newNode.setPrev( tmp1 );
	    tmp1.setNext( newNode );
	    tmp2.setPrev( newNode );

	    //increment size attribute
	    _size++;

	}
    }


    //remove node at pos index, return its cargo
    public Object remove( int index ) {

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	if ( index == 0 )
	    return removeFirst();
	else if ( index == size()-1 )
	    return removeLast();
	else {
	    DLLNode<E> tmp1 = _head; //create alias to head

	    //walk to node before desired node
	    for( int i=0; i < index-1; i++ ) {
		tmp1 = tmp1.getNext();
		System.out.println( "tmp1: " + tmp1.getCargo() );
	    }
	    //check target node's cargo hold
	    Object retVal = tmp1.getNext().getCargo();

	    //remove target node
	    tmp1.setNext( tmp1.getNext().getNext() );
	    System.out.println( "tmp1.getNext: " + tmp1.getNext().getCargo() );
	    tmp1.getNext().setPrev( tmp1 );

	    _size--;

	    return retVal;
	}
    }


    public Object get( int index ) { 

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	Object retVal;
	DLLNode<E> tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//check target node's cargo hold
	retVal = tmp.getCargo();
	return retVal;
    } 


    public Object set( int index, Object newVal ) { 

	if ( index < 0 || index >= size() )
	    throw new IndexOutOfBoundsException();

	DLLNode<E> tmp = _head; //create alias to head

	//walk to desired node
	for( int i=0; i < index; i++ )
	    tmp = tmp.getNext();

	//store target node's cargo
	Object oldVal = tmp.getCargo();
	
	//modify target node's cargo
	tmp.setCargo( newVal );
	
	return oldVal;
    } 


    //return number of nodes in list
    public int size() { return _size; } 
    //--------------^  List interface methods  ^--------------


    //--------------v  Helper methods  v--------------

    public void addFirst( Object newFirstVal ) { 
	//insert new node before first node (prev=null, next=_head)
	_head = new DLLNode<E>( newFirstVal, null, _head );

	if ( _size == 0 ) 
	    _tail = _head;
	else 
	    _head.getNext().setPrev( _head );
	_size++;
    }

    public void addLast( Object newLastVal ) { 
	//insert new node after last node (prev=_last, next=null)
	_tail = new DLLNode<E>( newLastVal, _tail, null );

	if ( _size == 0 ) 
	    _head = _tail;
	else 
	    _tail.getPrev().setNext( _tail );
	_size++;
    }

    public Object getFirst() { return _head.getCargo(); }

    public Object getLast() { return _tail.getCargo(); }

    public Object removeFirst() { 
	Object retVal = getFirst();
	if ( size() == 1 ) {
	    _head = _tail = null;
	}
	else {
	    _head = _head.getNext();
	    _head.setPrev( null );
	}
	_size--;
	return retVal;
    }

    public Object removeLast() { 
	Object retVal = getLast();
	if ( size() == 1 ) {
	    _head = _tail = null;
	}
	else {
	    _tail = _tail.getPrev();
	    _tail.setNext( null );
	}
	_size--;
	return retVal;
    }
    //--------------^  Helper methods  ^--------------


    // override inherited toString
    public String toString() { 
	String retStr = "HEAD->";
	DLLNode<E> tmp = _head; //init tr
	while( tmp != null ) {
	    retStr += tmp.getCargo() + "->";
	    tmp = tmp.getNext();
	}
	retStr += "NULL";
	return retStr;
    }


    //main method for testing
    public static void main( String[] args ) {

	LList james = new LList();

	System.out.println("initially: " );
	System.out.println( james + "\tsize: " + james.size() );

	james.add("beat");
	System.out.println( james + "\tsize: " + james.size() );

	james.add("a");
	System.out.println( james + "\tsize: " + james.size() );

	james.add("need");
	System.out.println( james + "\tsize: " + james.size() );

	james.add("I");
	System.out.println( james + "\tsize: " + james.size() );

	System.out.println( "2nd item is: " + james.get(1) );

	System.out.println( "...and now 2nd item is: " + james.set(1,"got") );
	System.out.println( james + "\tsize: " + james.size() );

	james.add(0,"whut");
	System.out.println( "...after add(0,whut): " );
	System.out.println( james + "\tsize: " + james.size() );

	james.add(4,"phat");
	System.out.println( "...after add(4,phat): " );
	System.out.println( james + "\tsize: " + james.size() );

	System.out.println( "...after remove last: " 
			    + james.remove( james._size-1) );
	System.out.println( james + "\tsize: " + james.size() );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james + "\tsize: " + james.size() );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james + "\tsize: " + james.size() );

	System.out.println( "...after remove(0): " + james.remove(0) );
	System.out.println( james + "\tsize: " + james.size() );

	
	//Credits to Jack Schluger on Piazza. Got home late after PTC, and free test cases are always amazing!
	LList l4 = new LList();
	Object[] foo = new Object[] {0,1,2,3,4,5,6,7,8,9};
	for (Object o : foo) l4.add(o);

	DLLNode pointy = l4._tail;

	while (pointy != null) {
	    System.out.print(pointy + " -> ");
	    pointy = pointy.getPrev();
	}
	System.out.println();

	l4.add(1,"JOHN CENAA");
	l4.add('a');

	l4.add(0, "first");

	pointy = l4._tail;

	while (pointy != null) {
	    System.out.print(pointy + " -> ");
	    pointy = pointy.getPrev();
	}

	System.out.println("\n");
	
	System.out.println("l4 (using toString()): \t" + l4);

	l4.remove(0);
	System.out.println("removing i=0...\t\t" + l4);

	l4.remove(l4.size() - 1);
	System.out.println("removing i=size-1...\t" + l4);

	l4.remove(1);
	System.out.println("removing i=1...\t\t" + l4);

	System.out.print("\nprinting from tail...\n\t");

	pointy = l4._tail;

	while (pointy != null) {
	    System.out.print(pointy + " -> ");
	    pointy = pointy.getPrev();
	}

	System.out.print("\nprinting from head...\n\t");

	pointy = l4._head;

	while (pointy != null) {
	    System.out.print(pointy + " -> ");
	    pointy = pointy.getNext();
	}

	System.out.println();
    }

}//end class LList



