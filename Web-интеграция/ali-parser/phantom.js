var page = new WebPage();
var fs = require("fs");
var cheerio = require("cheerio");

page.onLoadFinished = function () {
  console.log("page load finished");
  fs.write("data2.txt", page.content, "w");

  phantom.exit();
};

page.open(
  "https://www.dx.com/p/bluetooth-50-42-audio-receiver-transmitter-3-in-1-35mm-35-aux-jack-usb-stereo-music-wireless-adapters-for-car-tv-mp3-pc-2734705.html#.Y3qC9XZBxD8",
  function () {
    page.evaluate(function () {});
  }
);
