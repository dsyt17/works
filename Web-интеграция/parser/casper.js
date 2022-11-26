const fs = require("fs");
const system = require("system");
var casper = require('casper').create();

casper.start(system.args[4], function() {
    console.log(system.args[4]);
    const html = this.getHTML()
    fs.write("response_html.txt", html, "w");
    this.echo(this.getTitle());
});

casper.run();