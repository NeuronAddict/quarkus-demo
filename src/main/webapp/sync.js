const fs = require('fs-extra');
const {throws} = require("assert");

async function sync () {
    try {
        await fs.copy('build', '../resources/META-INF/resources');
        console.log('successfull copy build/ to ../resources/META-INF/resources/');
        return false;
    } catch (err) {
        console.error(err);
        return err;
    }
}

sync().catch(reason => throws(reason));
