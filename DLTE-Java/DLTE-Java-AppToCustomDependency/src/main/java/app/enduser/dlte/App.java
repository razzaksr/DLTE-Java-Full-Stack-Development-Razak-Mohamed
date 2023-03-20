package app.enduser.dlte;

import datasource.library.dlte.Services;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        Services services=new Services();
        System.out.println(services.fetch());
    }
}
