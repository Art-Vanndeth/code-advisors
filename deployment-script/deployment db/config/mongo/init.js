printjson({
    'MONGO_INITDB_DATABASE': process.env.MONGO_INITDB_DATABASE,
    'DB_USERNAME': process.env.DB_USERNAME,
    'DB_PASSWORD': 'HIDDEN'
});

const dbName = process.env.MONGO_INITDB_DATABASE || 'test';
const db = db.getSiblingDB(dbName);

const username = process.env.DB_USERNAME || 'myuser';
const password = process.env.DB_PASSWORD || 'mypassword';

try {
    // Create the user with readWrite role on the specified database
    db.createUser({
        user: username,
        pwd: password,
        roles: [
            {
                role: 'readWrite',
                db: dbName
            },
            {
                role: 'clusterMonitor',
                db: 'admin'
            }
        ]
    });
    print('Successfully created user: ' + username);
} catch (error) {
    print('Error creating user: ' + error.message);
    printjson(error);
}