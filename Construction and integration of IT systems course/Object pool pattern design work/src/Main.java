public class Main {

    public static void main(String[] args) {
        Pool pool = Pool.getInstance();

        for ( int count = 0; count < Pool.poolSize + 1; ++count ) {
            Client client = pool.acquireClient();
            if ( client == null ) {
                System.out.println( count + "- no active client left!" );
                break;
            }
            System.out.println( count + "- Active client " + client.hashCode() );
        }

        for ( int count = 0; count < Pool.poolSize + 1; ++count ) {
            Client client = pool.acquireClient();
            if ( client == null ) {
                System.out.println( count + "- no active client left" );
                break;
            }
            System.out.println( count + "- active client " + client.hashCode() );
        }
    }
}
