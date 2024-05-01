
public class MySQLFactory extends GeneralFactory {

    @Override
    public Database getDatabase(String dbType) {
        Database db = new MySQLDatabase();
    }
    
    @Override
    public ChatMediator getMediator(String chatType) {
        return new ChatMediatorMySQL();
    }

    @Override
    public MediaOperation getMedia(String mediaType) {
        return new MediaOperationMySQL();
    }
    
    @Override
    public ProfileOperation getProfile(String profileType) {
        return new ProfileOperationMySQL();
    }
    
}




