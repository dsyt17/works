import cheerio from "cheerio";
import fs from "fs";
import mysql from "mysql2";

// https://www.dx.com/p/blackview-p10000-pro-octa-core-5-99-mobile-phone-2002771.html#.Y4HxmnYzZD8

const parse = () => {
  const data = fs.readFileSync("response_html.txt", "utf8");

  let $ = cheerio.load(data);
  $("#productDescriptBox br").remove();

  const item = {
    title: $(".pinfo-title").text(),
    raiting: $(".starts-num").text(),
    wish_list: $("#wishCount").text(),
    // description: $("#productDescriptBox").nextAll().text(),
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
    attributes: [[], []],
    link: process.argv[2],
  };

  // reviews
  $(".rantings-num.gray").text() &&
    (item.reviews = $(".rantings-num.gray").text());

  // full price
  $(".f16.gray").text() && (item.full_price = $(".f16.gray").text());

  // current price
  $(".sale-price i.currency.mr5").text() &&
    $(".sale-price i.low-sale-price").text() &&
    (item.current_price =
      $(".sale-price i.currency.mr5").text() +
      $(".sale-price i.low-sale-price").text());

  // attribute names
  const attrNames = $(".pinfo-item.pinfo-item-attr dt").toArray();
  attrNames.forEach((e, i) => {
    item.attributes[0].push($(attrNames[i]).text());
  });

  // attribute values
  const attrValues = $(".pinfo-item.pinfo-item-attr dd ul li").toArray();
  let flag = true;
  attrValues.forEach((e, i) => {
    if ($(attrValues[i]).hasClass("pinfo-attr-color")) {
      flag && item.attributes[1].push("Some Colors");
      flag = false;
      return;
    }
    item.attributes[1].push($(attrValues[i]).text());
  });

  console.log(item);

  return item;
};

const writeToMySql = async (item) => {
  const connection = mysql.createConnection({
    host: "localhost",
    user: "admin",
    database: "wordpress",
    password: "225506",
    socketPath: "/var/run/mysqld/mysqld.sock",
  });

  connection.connect((err) => {
    if (err) {
      return console.error("Ошибка: " + err.message);
    } else {
      console.log("Подключение к серверу MySQL успешно установлено");
    }
    var date = `${new Date().getDate()}.${new Date().getMonth()}.${+new Date().getFullYear()}`;

    var sql =
      "INSERT INTO `wp_posts` (`ID`, `post_author`, `post_date`, `post_date_gmt`, `post_content`, `post_title`, `post_excerpt`, `post_status`, `comment_status`, `ping_status`, `post_password`, `post_name`, `to_ping`, `pinged`, `post_modified`, `post_modified_gmt`, `post_content_filtered`, `post_parent`, `guid`, `menu_order`, `post_type`, `post_mime_type`, `comment_count`) " +
      `VALUES (NULL, '1', '${date}', '${date}', '<!-- wp:paragraph -->\r\n<p><a href=${item.link}>Ссылка на товар</a></p>
      \r\n<p><strong>Текущая цена:</strong> ${
        item.current_price
      }</p>${
        item.full_price &&
        `\r\n<p><strong>Цена без скидки:</strong> ${item.full_price}</p>`
      }\r\n<p>Рейтинг: ${item.raiting ? item.raiting : "0"} Из ${
        item.reviews ? item.reviews : "0"
      } оценок</p>\r\n<p>Остаток: ${item.available} штук; В желаемом ${
        item.wish_list
      } </p>\r\n<p>Доставка: ${
        item.shippment
      }</p>\r\n<p>Атрибуты: 
      ${item.attributes[0].map((elem) => ` <span>${elem.replace(':', '')}</span>`)} /
      ${item.attributes[1].map((elem) => ` <span>${elem}</span>`)}
      </p>\r\n<img src="${item.image}"></img>\r\n<!-- /wp:paragraph -->', '${
        item.title
      }', '', 'publish', 'open', 'open', '', '${Math.floor(
        Math.random() * 100000000000000001
      )}', '', '', '2022-10-28 16:41:46', '2022-10-28 16:41:46', '', '0', 'http://goncharovigor.com/?p=1111', '0', 'post', '', '0'); `;

    connection.query(sql, function (err, result) {
      if (err) {
        return console.error("Ошибка: " + err.message);
      }
      console.log("Запись вставлена");

      connection.end((err) => {
        if (err) {
          return console.log("Ошибка: " + err.message);
        }
        console.log("Подключение закрыто");
      });
    });
  });
};

const item = parse();
writeToMySql(item)
