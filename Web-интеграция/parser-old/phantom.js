const page = new WebPage();
const fs = require("fs");
const system = require("system");
const args = system.args;

const url = args[1];

page.onLoadFinished = function () {
  console.log("Page loadead");
  fs.write("data.txt", page.content, "w");
  phantom.exit();
};

page.open(url, function () {
  page.evaluate(function () {});
});
