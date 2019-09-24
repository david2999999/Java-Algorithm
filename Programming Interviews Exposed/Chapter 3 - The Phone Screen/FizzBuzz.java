for ( int i = 1; i <= 100; ++i ) {
    boolean divByThree = ( i % 3 == 0 );
    boolean divByFive = ( i % 5 == 0 );

    if ( divByThree && divByFive ) {
        System.out.println( "FizzBuzz" );
    } else if ( divByThree ) {
        System.out.println( "Fizz" );
    } else if ( divByFive ) {
        System.out.println( "Buzz" );
    } else {
        System.out.println( i );
    }
}