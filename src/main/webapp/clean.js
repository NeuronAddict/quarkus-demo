const fs = require('fs-extra');
const {throws} = require("assert");

async function clean () {
    try {
        await fs.remove('/build');
        await fs.remove('../resources/META-INF/resources');
        console.log('successfull clean build and ../resources/META-INF/resources');
    } catch (err) {
        console.error(err);
    }
}

clean().catch(reason => throws(reason));
