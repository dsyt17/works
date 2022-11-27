const page = new WebPage();
const fs = require("fs");
const system = require("system");

const url = system.args[1];

page.onLoadFinished = function () {
    console.log(url);
    console.log("Page loadead");
    fs.write("response_html.txt", page.content, "w");
    phantom.exit();
};

page.open(url, function () {
  page.evaluate(function () {});
});
