package org.tron.application;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import org.tron.consensus.client.Client;
import org.tron.consensus.server.Server;
import org.tron.storage.leveldb.LevelDbDataSourceImpl;

import javax.inject.Named;

import static org.tron.core.Constant.BLOCK_DB_NAME;
import static org.tron.core.Constant.TRANSACTION_DB_NAME;

public class Module extends AbstractModule {

    @Override
    protected void configure() {

    }

    @Provides
    @Singleton
    public Client buildClient() {
        return new Client();
    }

    @Provides
    @Singleton
    public Server buildServer() {
        return new Server();
    }

    @Provides
    @Singleton
    @Named("transaction")
    public LevelDbDataSourceImpl buildTransactionDb() {
        LevelDbDataSourceImpl db = new LevelDbDataSourceImpl(TRANSACTION_DB_NAME);
        db.initDB();
        return db;
    }

    @Provides
    @Singleton
    @Named("block")
    public LevelDbDataSourceImpl buildBlockDb() {
        LevelDbDataSourceImpl db = new LevelDbDataSourceImpl(BLOCK_DB_NAME);
        db.initDB();
        return db;
    }
}
