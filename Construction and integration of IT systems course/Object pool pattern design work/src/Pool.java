import java.util.ArrayList;

public class Pool {
    private ArrayList<Client> objects;
    public static final int poolSize = 10;
    private int maxPoolSize = poolSize;

    protected static Pool instance = null;
    protected Pool() {objects = new ArrayList<Client>();}

    public int getMaxPoolSize() {return maxPoolSize;}

    public void setMaxPoolSize(int maxPoolSize) {this.maxPoolSize = maxPoolSize;
    }

    public Client acquireClient()
    {
        Lock desiredObject = new Lock();
        for ( Client client : objects) {
            if ( !client.isActive() ) {
                client.setInUse(true);
                desiredObject.release();
                return client;
            }
        }
        if ( objects.size() >= getMaxPoolSize() ) {
            desiredObject.release();
            return null;
        }
        Client client = new Client();
        client.setInUse(true);
        objects.add(client);

        desiredObject.release();
        return client;
    }

    public void releaseClient(Client subject )
    {
        Lock desiredObject = new Lock();
        int idx  = objects.indexOf( subject );
        if ( idx == -1 ) {
            desiredObject.release();
            return;
        }
        Client client = objects.get( idx );
        client.setInUse(false);
        desiredObject.release();
    }

    public static Pool getInstance()
    {
        Lock desiredObject = new Lock();

        if (instance == null) {instance = new Pool();
        }
        desiredObject.release();
        return instance;
    }
}