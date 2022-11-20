import cheerio from "cheerio";
import fs from "fs";

const parse = () => {
  const data = fs.readFileSync("./data2.txt", "utf8");
  // console.log(data);

  let $ = cheerio.load(data);
  $("#productDescriptBox br").remove();

  const item = {
    title: $(".pinfo-title").text(),
    raiting: $(".starts-num").text(),
    reviews: $(".rantings-num.gray").text(),
    wish_list: $("#wishCount").text(),
    description: $("#productDescriptBox").text(),
    full_price: $(".f16.gray").text(),
    current_price:
      $(".sale-price i.currency.mr5").text() +
      $(".sale-price i.low-sale-price").text(),
    // shop_raiting: $(".goodsStore_avgRate").text(),
    shippment:
      $(".tmiddle span.cost").text() +
      " to " +
      $(".tmiddle span.logistics-country").text() +
      " by " +
      $(".tmiddle span.logistics-type").text() +
      " on " +
      $(".logistics-time").text(),
    available: $(".stock-num.mr5").text(),
    image: $(".max-photo").find("img").attr("src"),
  };

  console.log(item);
};

parse();
