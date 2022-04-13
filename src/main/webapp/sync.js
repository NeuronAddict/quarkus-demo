const Rsync = require('rsync');

// Build the command
const rsync = new Rsync()
    .archive()
    .source('build/*')
    .destination('../resources/META-INF/resources');

// Execute the command
rsync.execute(function(error, code, cmd) {
    console.log('All done executing', cmd);
});
