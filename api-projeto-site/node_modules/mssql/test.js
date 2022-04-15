'use strict'
const mssql = require('./')

const [, , max] = process.argv

const sqlConfig = {
  password: 'P@ssw0rd',
  database: 'test',
  stream: false,
  // driver: 'msnodesqlv8',
  options: {
    trustServerCertificate: true,
    enableArithAbort: true,
    encrypt: true,
    abortTransactionOnError: false
  },
  pool: {
    max: max ? parseInt(max) : 10,
    min: 0
  },
  port: 1433,
  user: 'sa',
  server: 'localhost'
};

(async () => {
  const pool = new mssql.ConnectionPool(sqlConfig)
  try {
    await pool.connect();

    const  request = pool.request();
    request.arrayRowMode = true;
    request.multiple = true;

    const result = await request.batch('SELECT 1;');

    Object.entries(result.recordset.columns).forEach(([key, value]) => {
      console.log(`Column: ${key}, ${JSON.stringify(value)}`);
    });
  } catch (err) {
    console.error(err)
  } finally {
    console.log('closing pool')
    await pool.close()
    console.log('closed')
  }
})()
