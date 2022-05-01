const Rsync = require('rsync');

console.log('[React sync] Sync frontend. current folder = ', process.cwd())

// Build the command
const rsync = new Rsync()
    .archive()
    .source('build/*')
    .destination('../resources/META-INF/resources');

// Execute the command
rsync.execute(function(error, code, cmd) {
    console.log('[React sync] All done executing ', cmd);
});
