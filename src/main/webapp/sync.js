const Rsync = require('rsync');

console.log('[React sync] Sync frontend. current folder = ', process.cwd())

// Build the command
const rsync = new Rsync()
    .archive()
    .source('build/*')
    .destination('../resources/META-INF/resources')
    .flags('v', true);

// Execute the command
rsync.execute(function(error, code, stderr) {
    console.log('[React sync] All done executing ', code);
    if( code !== 0) {
        console.error(stderr, error);
        throw Error(stderr);
    }
});

